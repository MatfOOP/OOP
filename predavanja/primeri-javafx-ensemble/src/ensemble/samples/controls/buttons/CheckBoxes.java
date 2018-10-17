/*
 * Copyright (c) 2008, 2011 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle Corporation nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package ensemble.samples.controls.buttons;

import ensemble.Sample;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

/**
 * An example of checkboxes in various states.
 *
 * @see javafx.scene.control.CheckBox
 * @related controls/buttons/GraphicButton
 * @related controls/buttons/RadioButtons
 */

public class CheckBoxes extends Sample {
    
    public CheckBoxes() {
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        CheckBox cb1 = new CheckBox("Simple checkbox");

        CheckBox cb2 = new CheckBox("Three state checkbox");
        cb2.setAllowIndeterminate(true);
        cb2.setIndeterminate(false);

        CheckBox cb3 = new CheckBox("Disabled");
        cb3.setSelected(true);
        cb3.setDisable(true);

        vbox.getChildren().add(cb1);
        vbox.getChildren().add(cb2);
        vbox.getChildren().add(cb3);
        getChildren().add(vbox);
    }
}

