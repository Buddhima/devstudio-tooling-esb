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

package org.wso2.developerstudio.esb.form.editors.article.rcp;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.wso2.developerstudio.eclipse.gmf.esb.TaskProperty;
import org.wso2.developerstudio.esb.forgm.editors.article.FormArticlePlugin;

/**
 * 
 * To change the template for this generated type comment go to Window - Preferences - Java - Code Generation - Code and
 * Comments
 */
public class ScheduledTaskFormPage extends FormPage {

	private Text taskName;
	private Text taskGroup;
	private Text pinnedServers;
	private Text taskImpl;
	private Text taskImplProp;
	private Text count;
	private Text interval;
	private Text cron;
	private Combo triggerType;
	private Label countLbl;
	private Label cronLbl;
	private Label intervalLbl;
	private List<TaskProperty> taskPropertyList;

	/**
	 * @param id
	 * @param title
	 */
	public ScheduledTaskFormPage(FormEditor editor) {
		super(editor, "scheduledTaskForm", Messages.getString("ScheduledTaskPage.sectionMainTitle"));
	}

	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		FormToolkit toolkit = managedForm.getToolkit();
		form.setText(Messages.getString("ScheduledTaskPage.sectionMainTitle"));
		form.setBackgroundImage(FormArticlePlugin.getDefault().getImage(FormArticlePlugin.IMG_FORM_BG));

		ColumnLayout layout = new ColumnLayout();
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		layout.maxNumColumns = 2;
		form.getBody().setLayout(layout);

		createFormBasicSection(form, toolkit);
		createFormMiscSection(form, toolkit);
		createFormImplSection(form, toolkit);
		createFormTriggerSection(form, toolkit);

	}

	private void createFormBasicSection(final ScrolledForm form, FormToolkit toolkit) {
		/* Basic Section */
		Section basicSection = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.EXPANDED);
		basicSection.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
		basicSection.setToggleColor(toolkit.getColors().getColor(FormColors.SEPARATOR));
		toolkit.createCompositeSeparator(basicSection);

		basicSection.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		basicSection.setText(Messages.getString("ScheduledTaskPage.section.basic"));
		// section.setLayoutData(new TableWrapData(TableWrapData.FILL));

		Composite basicSectionClient = toolkit.createComposite(basicSection);
		basicSectionClient.setLayout(new TableWrapLayout());

		toolkit.createLabel(basicSectionClient, "Task Name");
		taskName = toolkit.createText(basicSectionClient, "");
		taskName.setBackground(new Color(null, 229, 236, 253));
		taskName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

		toolkit.createLabel(basicSectionClient, "Task Group");
		taskGroup = toolkit.createText(basicSectionClient, "synapse.simple.quartz");
		taskGroup.setBackground(new Color(null, 229, 236, 253));
		taskGroup.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

		basicSection.setClient(basicSectionClient);

	}

	private void createFormMiscSection(final ScrolledForm form, FormToolkit toolkit) {
		/* Misc. Section */
		Section miscSection = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.EXPANDED);
		miscSection.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
		miscSection.setToggleColor(toolkit.getColors().getColor(FormColors.SEPARATOR));
		toolkit.createCompositeSeparator(miscSection);

		miscSection.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		miscSection.setText(Messages.getString("ScheduledTaskPage.section.misc"));
		// miscSection.setLayoutData(new TableWrapData(TableWrapData.FILL));

		Composite miscSectionClient = toolkit.createComposite(miscSection);
		miscSectionClient.setLayout(new TableWrapLayout());

		toolkit.createLabel(miscSectionClient, "Pinned Servers");
		pinnedServers = toolkit.createText(miscSectionClient, "");
		pinnedServers.setBackground(new Color(null, 229, 236, 253));
		pinnedServers.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

		miscSection.setClient(miscSectionClient);
	}

	private void createFormImplSection(final ScrolledForm form, FormToolkit toolkit) {
		/* Task Implementation Section */
		Section implSection = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.EXPANDED);
		implSection.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
		implSection.setToggleColor(toolkit.getColors().getColor(FormColors.SEPARATOR));
		toolkit.createCompositeSeparator(implSection);

		implSection.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		implSection.setText(Messages.getString("ScheduledTaskPage.section.impl"));
		// implSection.setLayoutData(new TableWrapData(TableWrapData.FILL));

		Composite implSectionClient = toolkit.createComposite(implSection);
		implSectionClient.setLayout(new TableWrapLayout());

		toolkit.createLabel(implSectionClient, "Task Implementation");
		taskImpl = toolkit.createText(implSectionClient, "org.apache.synapse.startup.tasks.MessageInjector");
		taskImpl.setBackground(new Color(null, 229, 236, 253));
		// taskImpl.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

		Button taskImplButton = toolkit.createButton(implSectionClient, "Task Implementation Properties", SWT.PUSH);
		taskImplButton.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = Display.getDefault().getActiveShell();
				TaskPropertyDialog taskPropDialog = new TaskPropertyDialog(shell, getTaskImpl().getText(),
						getTaskPropertyList());
				taskPropDialog.setBlockOnOpen(true);
				taskPropDialog.open();
				taskPropertyList = taskPropDialog.getTaskPropertyList();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		setTaskPropertyList(taskPropertyList);

		// taskImplProp.setLayoutData(new
		// TableWrapData(TableWrapData.FILL_GRAB));

		implSection.setClient(implSectionClient);
	}

	private void createFormTriggerSection(final ScrolledForm form, final FormToolkit toolkit) {
		/* Trigger Information */
		Section triggerSection = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.EXPANDED);
		triggerSection.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
		triggerSection.setToggleColor(toolkit.getColors().getColor(FormColors.SEPARATOR));
		toolkit.createCompositeSeparator(triggerSection);

		triggerSection.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		triggerSection.setText(Messages.getString("ScheduledTaskPage.section.trigger"));
		// triggerSection.setLayoutData(new TableWrapData(TableWrapData.FILL));

		final Composite triggerSectionClient = toolkit.createComposite(triggerSection);
		triggerSectionClient.setLayout(new TableWrapLayout());

		toolkit.createLabel(triggerSectionClient, "Trigger Type");
		triggerType = new Combo(triggerSectionClient, SWT.READ_ONLY);
		triggerType.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		// triggerType.setBackground(new Color(null, 229,236,253));
		String[] triggerTypes = { "Simple", "Cron" };
		triggerType.setItems(triggerTypes);

		cronLbl = toolkit.createLabel(triggerSectionClient, "Cron");
		cron = toolkit.createText(triggerSectionClient, "");
		cron.setBackground(new Color(null, 229, 236, 253));
		cron.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		disableCronFields();

		countLbl = toolkit.createLabel(triggerSectionClient, "Count");
		count = toolkit.createText(triggerSectionClient, "1");
		count.setBackground(new Color(null, 229, 236, 253));
		count.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

		intervalLbl = toolkit.createLabel(triggerSectionClient, "Interval");
		interval = toolkit.createText(triggerSectionClient, "0");
		interval.setBackground(new Color(null, 229, 236, 253));
		interval.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		enableSimpleFields();

		triggerType.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (triggerType.getSelectionIndex() == 0) {
					disableCronFields();
					enableSimpleFields();
				} else if (triggerType.getSelectionIndex() == 1) {
					enableCronFields();
					disableSimpleFields();
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		triggerSection.setClient(triggerSectionClient);
	}

	public Text getTaskName() {
		return taskName;
	}

	public void setTaskName(Text taskName) {
		this.taskName = taskName;
	}

	public Text getTaskGroup() {
		return taskGroup;
	}

	public void setTaskGroup(Text taskGroup) {
		this.taskGroup = taskGroup;
	}

	public Text getPinnedServers() {
		return pinnedServers;
	}

	public void setPinnedServers(Text pinnedServers) {
		this.pinnedServers = pinnedServers;
	}

	public Text getTaskImpl() {
		return taskImpl;
	}

	public void setTaskImpl(Text taskImpl) {
		this.taskImpl = taskImpl;
	}

	public Text getTaskImplProp() {
		return taskImplProp;
	}

	public void setTaskImplProp(Text taskImplProp) {
		this.taskImplProp = taskImplProp;
	}

	public Text getCount() {
		return count;
	}

	public void setCount(Text count) {
		this.count = count;
	}

	public Text getInterval() {
		return interval;
	}

	public void setInterval(Text interval) {
		this.interval = interval;
	}

	public Text getCron() {
		return cron;
	}

	public void setCron(Text cron) {
		this.cron = cron;
	}

	public Combo getTriggerType() {
		return triggerType;
	}

	public void setTriggerType(Combo triggerType) {
		this.triggerType = triggerType;
	}

	public void setTaskPropertyList(List<TaskProperty> taskPropertyList) {
		this.taskPropertyList = taskPropertyList;

	}

	public List<TaskProperty> getTaskPropertyList() {
		return taskPropertyList;
	}

	/**
	 * Check if cron contain any values
	 * 
	 * @param isCron
	 */

	public void setCheckCron(boolean isCron) {
		if (isCron) {
			enableCronFields();
			disableSimpleFields();
		}
	}

	/**
	 * Enable cron fields when opening the form editor if it contains cron values
	 */
	private void enableCronFields() {
		cron.setVisible(true);
		cronLbl.setVisible(true);
	}

	/**
	 * Check if simple contain any values
	 * 
	 * @param isSimple
	 */
	public void setCheckSimple(boolean isSimple) {
		if (isSimple) {
			enableSimpleFields();
			disableCronFields();
		}
	}

	/**
	 * Enable simple fields when opening the form editor if it contains simple values
	 */
	private void enableSimpleFields() {
		countLbl.setVisible(true);
		count.setVisible(true);
		intervalLbl.setVisible(true);
		interval.setVisible(true);
	}

	private void disableSimpleFields() {
		countLbl.setVisible(false);
		count.setVisible(false);
		intervalLbl.setVisible(false);
		interval.setVisible(false);
	}

	private void disableCronFields() {
		cron.setVisible(false);
		cronLbl.setVisible(false);
	}

}