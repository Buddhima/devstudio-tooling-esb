/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.esb.form.editors.article.rcp.message.processors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.wso2.developerstudio.esb.form.editors.article.rcp.Messages;

public class ScheduledForwarding implements IMessageProcessor {
    public Text forwarding_endpoint;
    public Combo forwarding_state;
    public Text forwarding_interval;
    public Text forwarding_retryInterval;
    public Text forwarding_nonRetryHttpCodes;
    public Text forwarding_maxDeliveryAttempts;
    public Combo forwarding_dropMessageAfterMaxDeliveryAttempts;
    public Text forwarding_axis2ClientRepo;
    public Text forwarding_axis2Config;
    public Text forwarding_replySequence;
    public Text forwarding_faultSequence;
    public Text forwarding_deactiveSequence;
    public Text forwarding_quartzConfigFilePath;
    public Text forwarding_cronExpression;
    public Text forwarding_taskCount;
//    public Text forwarding_customParameters;
    
    private ScrolledForm form;
    private FormToolkit toolkit;
    
    Section miscSection;
    Section parameterSection;

    public ScheduledForwarding(ScrolledForm form, FormToolkit toolkit) {
    	this.form = form;
    	this.toolkit = toolkit;
	}

    @Override
    public void createMiscSectionFields() {
    	 /* Misc Section */ 
		miscSection = this.createSection(form, toolkit, Messages.getString("MessageProcessorPage.section.misc"));
		
		Composite miscSectionClient = toolkit.createComposite(miscSection);
		miscSectionClient.setLayout(new TableWrapLayout());
		miscSection.setClient(miscSectionClient);
		
		miscSection.setVisible(false);
		
        toolkit.createLabel(miscSectionClient, "Endpoint Name");
        forwarding_endpoint = toolkit.createText(miscSectionClient, "");
        forwarding_endpoint.setBackground(new Color(null, 229,236,253));
        forwarding_endpoint.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

    }

    @Override
    public void createParameterSectionFields() {
    	
    	parameterSection = this.createSection(form, toolkit, Messages.getString("MessageProcessorPage.section.parameter"));
		
		Composite parameterSectionClient = toolkit.createComposite(parameterSection);
		parameterSectionClient.setLayout(new TableWrapLayout());
		parameterSection.setClient(parameterSectionClient);
		
		parameterSection.setVisible(false);
    	
        toolkit.createLabel(parameterSectionClient, "Processor State");
        forwarding_state = new Combo(parameterSectionClient, SWT.DROP_DOWN);
        forwarding_state.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        String[] states = {"Active", "Deactive"};
        forwarding_state.setItems(states);

        toolkit.createLabel(parameterSectionClient, "Forwarding Interval");
        forwarding_interval = toolkit.createText(parameterSectionClient, "");
        forwarding_interval.setBackground(new Color(null, 229,236,253));
        forwarding_interval.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        toolkit.createLabel(parameterSectionClient, "Retry Interval");
        forwarding_retryInterval = toolkit.createText(parameterSectionClient, "");
        forwarding_retryInterval.setBackground(new Color(null, 229,236,253));
        forwarding_retryInterval.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        toolkit.createLabel(parameterSectionClient, "Non Retry Http Status Codes (eg - 304, 305)");
        forwarding_nonRetryHttpCodes = toolkit.createText(parameterSectionClient, "");
        forwarding_nonRetryHttpCodes.setBackground(new Color(null, 229,236,253));
        forwarding_nonRetryHttpCodes.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        toolkit.createLabel(parameterSectionClient, "Max Delivery Attempts");
        forwarding_maxDeliveryAttempts = toolkit.createText(parameterSectionClient, "");
        forwarding_maxDeliveryAttempts.setBackground(new Color(null, 229,236,253));
        forwarding_maxDeliveryAttempts.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        toolkit.createLabel(parameterSectionClient, "Drop Message After Maximum Delivery Attempts");
        forwarding_dropMessageAfterMaxDeliveryAttempts = new Combo(parameterSectionClient, SWT.DROP_DOWN);
        forwarding_dropMessageAfterMaxDeliveryAttempts.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        String[] dropConditions = {"Enabled", "Disabled"};
        forwarding_dropMessageAfterMaxDeliveryAttempts.setItems(dropConditions);

        addSeparator(form, toolkit, parameterSectionClient);

        toolkit.createLabel(parameterSectionClient, "Axis2 Client Repository");
        forwarding_axis2ClientRepo = toolkit.createText(parameterSectionClient, "");
        forwarding_axis2ClientRepo.setBackground(new Color(null, 229,236,253));
        forwarding_axis2ClientRepo.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));


        toolkit.createLabel(parameterSectionClient, "Axis2 Configuration");
        forwarding_axis2Config = toolkit.createText(parameterSectionClient, "");
        forwarding_axis2Config.setBackground(new Color(null, 229,236,253));
        forwarding_axis2Config.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        addSeparator(form, toolkit, parameterSectionClient);

        toolkit.createLabel(parameterSectionClient, "Reply Sequence Name");
        forwarding_replySequence = toolkit.createText(parameterSectionClient, "");
        forwarding_replySequence.setBackground(new Color(null, 229,236,253));
        forwarding_replySequence.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));


        toolkit.createLabel(parameterSectionClient, "Fault Sequence Name");
        forwarding_faultSequence = toolkit.createText(parameterSectionClient, "");
        forwarding_faultSequence.setBackground(new Color(null, 229,236,253));
        forwarding_faultSequence.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        toolkit.createLabel(parameterSectionClient, "Deactivate Sequence Name");
        forwarding_deactiveSequence = toolkit.createText(parameterSectionClient, "");
        forwarding_deactiveSequence.setBackground(new Color(null, 229,236,253));
        forwarding_deactiveSequence.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        addSeparator(form, toolkit, parameterSectionClient);

        toolkit.createLabel(parameterSectionClient, "Quartz Config File Path");
        forwarding_quartzConfigFilePath = toolkit.createText(parameterSectionClient, "");
        forwarding_quartzConfigFilePath.setBackground(new Color(null, 229,236,253));
        forwarding_quartzConfigFilePath.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        toolkit.createLabel(parameterSectionClient, "Cron Expression");
        forwarding_cronExpression = toolkit.createText(parameterSectionClient, "");
        forwarding_cronExpression.setBackground(new Color(null, 229,236,253));
        forwarding_cronExpression.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        toolkit.createLabel(parameterSectionClient, "Task Count");
        forwarding_taskCount = toolkit.createText(parameterSectionClient, "");
        forwarding_taskCount.setBackground(new Color(null, 229,236,253));
        forwarding_taskCount.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

//        addSeparator(form, toolkit, sectionClient);
//
//        toolkit.createLabel(sectionClient, "Custom Parameters");
//        forwarding_customParameters = toolkit.createText(sectionClient, "");
//        forwarding_customParameters.setBackground(new Color(null, 229,236,253));
//        forwarding_customParameters.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

    }

    @Override
    public boolean hasMisc() {
        return true;
    }

    @Override
    public boolean hasParameters() {
        return true;
    }

    private void addSeparator(final ScrolledForm form, FormToolkit toolkit, Composite client) {
        Label padBefore = toolkit.createLabel(client, null);
        TableWrapData padData = new TableWrapData();
        padData.maxWidth = 0;
        padBefore.setLayoutData(padData);
        Label separator = new Label(client, SWT.SEPARATOR + SWT.HORIZONTAL);
        TableWrapData separatorData = new TableWrapData();
        separatorData.align = TableWrapData.FILL;
        separatorData.grabHorizontal = true;
        separatorData.maxHeight = 1;
        separatorData.valign = TableWrapData.MIDDLE;
        separator.setLayoutData(separatorData);
        Label padAfter = toolkit.createLabel(client, null);
        padAfter.setLayoutData(padData);
    }
    
    private Section createSection(final ScrolledForm form, FormToolkit toolkit, final String heading) {
		
		Section section = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.EXPANDED);
		section.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
		section.setToggleColor(toolkit.getColors().getColor(FormColors.SEPARATOR));
		toolkit.createCompositeSeparator(section);
		
		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		section.setText(heading);
		
		return section;
	}
    
    @Override
	public void showParameterSectionFields() {
		parameterSection.setVisible(true);
		parameterSection.setExpanded(true);
	}

	@Override
	public void showMiscSectionFields() {
		miscSection.setVisible(true);
		miscSection.setExpanded(true);
	}

	@Override
	public void hideParameterSectionFields() {
		parameterSection.setVisible(false);
		parameterSection.setExpanded(false);
	}

	@Override
	public void hideMiscSectionFields() {
		miscSection.setVisible(false);
		miscSection.setExpanded(false);
	}

}
