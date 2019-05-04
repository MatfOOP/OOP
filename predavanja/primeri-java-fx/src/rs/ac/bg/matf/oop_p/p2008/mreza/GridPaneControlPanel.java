package rs.ac.bg.matf.oop_p.p2008.mreza;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.SliderBuilder;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;

/**
 * GridPaneControlPanel represents the left area of the split pane allowing the
 * user to manipulate the GridPane on the right.
 * 
 * Manipulating Layout Via Grids
 * 
 * @author cdea
 */
public class GridPaneControlPanel extends GridPane
{
	public GridPaneControlPanel(final GridPane targetGridPane)
	{
		super();
		setPadding(new Insets(5));
		setHgap(5);
		setVgap(5);
		// Setting Grid lines
		Label gridLinesLbl = new Label("Grid Lines");
		final ToggleButton gridLinesToggle = new ToggleButton("Off");
		gridLinesToggle.selectedProperty().addListener(
				new ChangeListener<Boolean>() {
					public void changed(ObservableValue<? extends Boolean> ov,
							Boolean oldValue, Boolean newVal)
					{
						targetGridPane.setGridLinesVisible(newVal);
						gridLinesToggle.setText(newVal ? "On" : "Off");
					}
				});
		// toggle grid lines label
		GridPane.setHalignment(gridLinesLbl, HPos.RIGHT);
		add(gridLinesLbl, 0, 0);
		// toggle grid lines
		GridPane.setHalignment(gridLinesToggle, HPos.LEFT);
		add(gridLinesToggle, 1, 0);
		// Setting padding [top]
		Label gridPaddingLbl = new Label("Top Padding");
		final Slider gridPaddingSlider = SliderBuilder.create().min(0).max(100)
				.value(5).showTickLabels(true).showTickMarks(true).minorTickCount(1)
				.blockIncrement(5).build();
		gridPaddingSlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number oldVal,
					Number newVal)
			{
				double top = targetGridPane.getInsets().getTop();
				double right = targetGridPane.getInsets().getRight();
				double bottom = targetGridPane.getInsets().getBottom();
				double left = targetGridPane.getInsets().getLeft();
				Insets newInsets = new Insets(newVal.doubleValue(), right, bottom, left);
				targetGridPane.setPadding(newInsets);
			}
		});
		// padding adjustment label
		GridPane.setHalignment(gridPaddingLbl, HPos.RIGHT);
		add(gridPaddingLbl, 0, 1);
		// padding adjustment slider
		GridPane.setHalignment(gridPaddingSlider, HPos.LEFT);
		add(gridPaddingSlider, 1, 1);
		// Setting padding [top]
		Label gridPaddingLeftLbl = new Label("Left Padding");
		final Slider gridPaddingLeftSlider = SliderBuilder.create().min(0).max(100)
				.value(5).showTickLabels(true).showTickMarks(true).minorTickCount(1)
				.blockIncrement(5).build();
		gridPaddingLeftSlider.valueProperty().addListener(
				new ChangeListener<Number>() {
					public void changed(ObservableValue<? extends Number> ov,
							Number oldVal, Number newVal)
					{
						double top = targetGridPane.getInsets().getTop();
						double right = targetGridPane.getInsets().getRight();
						double bottom = targetGridPane.getInsets().getBottom();
						double left = targetGridPane.getInsets().getLeft();
						Insets newInsets = new Insets(top, right, bottom, newVal
								.doubleValue());
						targetGridPane.setPadding(newInsets);
					}
				});
		// padding adjustment label
		GridPane.setHalignment(gridPaddingLeftLbl, HPos.RIGHT);
		add(gridPaddingLeftLbl, 0, 2);
		// padding adjustment slider
		GridPane.setHalignment(gridPaddingLeftSlider, HPos.LEFT);
		add(gridPaddingLeftSlider, 1, 2);
		// Horizontal gap
		Label gridHGapLbl = new Label("Horizontal Gap");
		final Slider gridHGapSlider = SliderBuilder.create().min(0).max(100).value(
				5).showTickLabels(true).showTickMarks(true).minorTickCount(1)
				.blockIncrement(5).build();
		gridHGapSlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number oldVal,
					Number newVal)
			{
				targetGridPane.setHgap(newVal.doubleValue());
			}
		});
		// hgap label
		GridPane.setHalignment(gridHGapLbl, HPos.RIGHT);
		add(gridHGapLbl, 0, 3);
		// hgap slider
		GridPane.setHalignment(gridHGapSlider, HPos.LEFT);
		add(gridHGapSlider, 1, 3);
		// Vertical gap
		Label gridVGapLbl = new Label("Vertical Gap");
		final Slider gridVGapSlider = SliderBuilder.create().min(0).max(100).value(
				5).showTickLabels(true).showTickMarks(true).minorTickCount(1)
				.blockIncrement(5).build();
		gridVGapSlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number oldVal,
					Number newVal)
			{
				targetGridPane.setVgap(newVal.doubleValue());
			}
		});
		// vgap label
		GridPane.setHalignment(gridVGapLbl, HPos.RIGHT);
		add(gridVGapLbl, 0, 4);
		// vgap slider
		GridPane.setHalignment(gridVGapSlider, HPos.LEFT);
		add(gridVGapSlider, 1, 4);
		// Cell Column
		Label cellCol = new Label("Cell Column");
		final TextField cellColFld = new TextField("0");
		// cell Column label
		GridPane.setHalignment(cellCol, HPos.RIGHT);
		add(cellCol, 0, 5);
		// cell Column field
		GridPane.setHalignment(cellColFld, HPos.LEFT);
		add(cellColFld, 1, 5);
		// Cell Row
		Label cellRowLbl = new Label("Cell Row");
		final TextField cellRowFld = new TextField("0");
		// cell Row label
		GridPane.setHalignment(cellRowLbl, HPos.RIGHT);
		add(cellRowLbl, 0, 6);
		// cell Row field
		GridPane.setHalignment(cellRowFld, HPos.LEFT);
		add(cellRowFld, 1, 6);
		// Horizontal Alignment
		Label hAlignLbl = new Label("Horiz. Align");
		final ChoiceBox hAlignFld = new ChoiceBox(FXCollections
				.observableArrayList("CENTER", "LEFT", "RIGHT"));
		hAlignFld.getSelectionModel().select("LEFT");
		// cell Row label
		GridPane.setHalignment(hAlignLbl, HPos.RIGHT);
		add(hAlignLbl, 0, 7);
		// cell Row field
		GridPane.setHalignment(hAlignFld, HPos.LEFT);
		add(hAlignFld, 1, 7);
		// Vertical Alignment
		Label vAlignLbl = new Label("Vert. Align");
		final ChoiceBox vAlignFld = new ChoiceBox(FXCollections
				.observableArrayList("BASELINE", "BOTTOM", "CENTER", "TOP"));
		vAlignFld.getSelectionModel().select("TOP");
		// cell Row label
		GridPane.setHalignment(vAlignLbl, HPos.RIGHT);
		add(vAlignLbl, 0, 8);
		// cell Row field
		GridPane.setHalignment(vAlignFld, HPos.LEFT);
		add(vAlignFld, 1, 8);
		// Vertical Alignment
		Label cellApplyLbl = new Label("Cell Constraint");
		final Button cellApplyButton = new Button("Apply");
		cellApplyButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event)
			{
				for (Node child : targetGridPane.getChildren())
				{
					int targetColIndx = 0;
					int targetRowIndx = 0;
					try
					{
						targetColIndx = Integer.parseInt(cellColFld.getText());
						targetRowIndx = Integer.parseInt(cellRowFld.getText());
					}
					catch (Exception e)
					{
					}
					System.out.println("child = " + child.getClass().getSimpleName());
					int col = GridPane.getColumnIndex(child);
					int row = GridPane.getRowIndex(child);
					if (col == targetColIndx && row == targetRowIndx)
					{
						GridPane.setHalignment(child, HPos.valueOf(hAlignFld
								.getSelectionModel().getSelectedItem().toString()));
						GridPane.setValignment(child, VPos.valueOf(vAlignFld
								.getSelectionModel().getSelectedItem().toString()));
					}

				}
			}
		});
		// cell Row label
		GridPane.setHalignment(cellApplyLbl, HPos.RIGHT);
		add(cellApplyLbl, 0, 9);
		// cell Row field
		GridPane.setHalignment(cellApplyButton, HPos.LEFT);
		add(cellApplyButton, 1, 9);
	}
}