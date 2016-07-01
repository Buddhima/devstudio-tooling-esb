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

public class ScheduledFailoverForwarding implements IMessageProcessor {

    public Text failover_store;
    public Combo failover_state;
    public Text failover_interval;
    public Text failover_retryInterval;
    public Text failover_maxDeliveryAttempts;
    public Combo failover_dropMessageAfterMaxDeliveryAttempts;
    public Text failover_faultSequence;
    public Text failover_deactiveSequence;
    public Text failover_quartzConfigFilePath;
    public Text failover_cronExpression;
    public Text failover_taskCount;
    
    ScrolledForm form;
    FormToolkit toolkit;
    
    Section miscSection;
    Section parameterSection;
    
    public ScheduledFailoverForwarding(ScrolledForm form, FormToolkit toolkit) {
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
    	
        toolkit.createLabel(miscSectionClient, "Target Message Store");
        failover_store = toolkit.createText(miscSectionClient, "");
        failover_store.setBackground(new Color(null, 229,236,253));
        failover_store.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        
        
    }

    @Override
    public void createParameterSectionFields() {
    	
    	parameterSection = this.createSection(form, toolkit, Messages.getString("MessageProcessorPage.section.parameter"));
		
		Composite parameterSectionClient = toolkit.createComposite(parameterSection);
		parameterSectionClient.setLayout(new TableWrapLayout());
		parameterSection.setClient(parameterSectionClient);
		
		parameterSection.setVisible(false);
    	
    	
        toolkit.createLabel(parameterSectionClient, "Processor State");
        failover_state = new Combo(parameterSectionClient, SWT.DROP_DOWN);
        failover_state.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        String[] states = {"Active", "Deactive"};
        failover_state.setItems(states);

        toolkit.createLabel(parameterSectionClient, "Forwarding Interval");
        failover_interval = toolkit.createText(parameterSectionClient, "");
        failover_interval.setBackground(new Color(null, 229,236,253));
        failover_interval.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        toolkit.createLabel(parameterSectionClient, "Retry Interval");
        failover_retryInterval = toolkit.createText(parameterSectionClient, "");
        failover_retryInterval.setBackground(new Color(null, 229,236,253));
        failover_retryInterval.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        toolkit.createLabel(parameterSectionClient, "Max Delivery Attempts");
        failover_maxDeliveryAttempts = toolkit.createText(parameterSectionClient, "");
        failover_maxDeliveryAttempts.setBackground(new Color(null, 229,236,253));
        failover_maxDeliveryAttempts.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        toolkit.createLabel(parameterSectionClient, "Drop Message After Maximum Delivery Attempts");
        failover_dropMessageAfterMaxDeliveryAttempts = new Combo(parameterSectionClient, SWT.DROP_DOWN);
        failover_dropMessageAfterMaxDeliveryAttempts.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
        String[] dropConditions = {"Enabled", "Disabled"};
        failover_dropMessageAfterMaxDeliveryAttempts.setItems(dropConditions);

        addSeparator(form, toolkit, parameterSectionClient);

        toolkit.createLabel(parameterSectionClient, "Fault Sequence Name");
        failover_faultSequence = toolkit.createText(parameterSectionClient, "");
        failover_faultSequence.setBackground(new Color(null, 229,236,253));
        failover_faultSequence.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        toolkit.createLabel(parameterSectionClient, "Deactivate Sequence Name");
        failover_deactiveSequence = toolkit.createText(parameterSectionClient, "");
        failover_deactiveSequence.setBackground(new Color(null, 229,236,253));
        failover_deactiveSequence.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        addSeparator(form, toolkit, parameterSectionClient);

        toolkit.createLabel(parameterSectionClient, "Quartz Config File Path");
        failover_quartzConfigFilePath = toolkit.createText(parameterSectionClient, "");
        failover_quartzConfigFilePath.setBackground(new Color(null, 229,236,253));
        failover_quartzConfigFilePath.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        toolkit.createLabel(parameterSectionClient, "Cron Expression");
        failover_cronExpression = toolkit.createText(parameterSectionClient, "");
        failover_cronExpression.setBackground(new Color(null, 229,236,253));
        failover_cronExpression.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

        toolkit.createLabel(parameterSectionClient, "Task Count");
        failover_taskCount = toolkit.createText(parameterSectionClient, "");
        failover_taskCount.setBackground(new Color(null, 229,236,253));
        failover_taskCount.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));


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
