/*
 * Copyright 2016 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.datamapper.diagram.custom.configuration.operator.transformers;

import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.wso2.developerstudio.datamapper.SchemaDataType;
import org.wso2.developerstudio.datamapper.diagram.custom.generator.ForLoopBean;
import org.wso2.developerstudio.datamapper.diagram.custom.generator.DifferentLevelArrayMappingConfigGenerator;
import org.wso2.developerstudio.datamapper.diagram.custom.generator.SameLevelRecordMappingConfigGenerator;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMOperation;
import org.wso2.developerstudio.datamapper.diagram.custom.model.DMVariable;
import org.wso2.developerstudio.datamapper.diagram.custom.util.ScriptGenerationUtil;

import static org.wso2.developerstudio.datamapper.diagram.custom.model.transformers.TransformerConstants.DELIMITER_TAG;
import static org.wso2.developerstudio.datamapper.diagram.custom.model.transformers.TransformerConstants.JS_TO_STRING;

/**
 * This class extended from the {@link AbstractDMOperatorTransformer} abstract class and generate script for concat
 * operation
 */
public class ConcatOperatorTransformer extends AbstractDMOperatorTransformer {

    @Override
    public String generateScriptForOperation(Class<?> generatorClass, List<DMVariable> inputVariables,
            Map<String, List<SchemaDataType>> variableTypeMap, Stack<ForLoopBean> parentForLoopBeanStack,
            DMOperation operator) {
        String concatOperator = (String) operator.getProperty(DELIMITER_TAG);
        if (concatOperator == null) {
            concatOperator = "";
        }
        StringBuilder operationBuilder = new StringBuilder();
        if (SameLevelRecordMappingConfigGenerator.class.equals(generatorClass)) {
            if (inputVariables.size() >= 2) {
                operationBuilder.append(inputVariables.get(0).getName() + JS_TO_STRING +".concat('" + concatOperator + "',"
                        + inputVariables.get(1).getName() + ");");
            } else if (inputVariables.size() == 1) {
                operationBuilder.append(inputVariables.get(0).getName() + ";");
            } else {
                operationBuilder.append("'';");
            }
        } else if (DifferentLevelArrayMappingConfigGenerator.class.equals(generatorClass)) {
            @SuppressWarnings("unchecked")
            Stack<ForLoopBean> tempParentForLoopBeanStack = (Stack<ForLoopBean>) parentForLoopBeanStack.clone();
            if (inputVariables.size() > 1) {
                operationBuilder.append(ScriptGenerationUtil.getPrettyVariableNameInForOperation(inputVariables.get(0),
                        variableTypeMap, parentForLoopBeanStack, true) + JS_TO_STRING);
                for (int variableIndex = 1; variableIndex < inputVariables.size(); variableIndex++) {
                    operationBuilder.append(".concat('" + concatOperator + "',"
                            + ScriptGenerationUtil.getPrettyVariableNameInForOperation(
                                    inputVariables.get(variableIndex), variableTypeMap, tempParentForLoopBeanStack, true)
                            + ")");
                }
                operationBuilder.append(";");
            } else if (inputVariables.size() == 1) {
                operationBuilder.append(ScriptGenerationUtil.getPrettyVariableNameInForOperation(inputVariables.get(0),
                        variableTypeMap, parentForLoopBeanStack, true) + JS_TO_STRING + ".concat('" + concatOperator + "');");
            } else {
                operationBuilder.append("'';");
            }
        } else {
            throw new IllegalArgumentException("Unknown MappingConfigGenerator type found : " + generatorClass);
        }
        return operationBuilder.toString();
    }
}
