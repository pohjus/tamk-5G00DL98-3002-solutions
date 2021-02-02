/**
 * @author Viljami Pietarila
 * @author Jussi Pohjolainen
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.FlowLayout




class MyWindow(title: String) : JFrame(title) {
    val changeTitle = JButton("Change Title")
    val animate = JButton("Animate")
    var animated = false

    init {

        setLayout(FlowLayout())
        changeTitle.addActionListener() { this.title ="Hello World" }
        animate.addActionListener() {
            if(!animated) {
                animated = true
                Thread() {
                    while (animated) {
                        this.setLocation((0..200).random(), (0..200).random())
                        Thread.sleep(1000)
                    }
                }.start()
            } else {
                animated = false

            }
        }

        add(changeTitle)
        add(animate)
    }
}

fun main() {
    val window = MyWindow("Kotlin is Fun!");
    window.pack()
    window.setVisible(true)
}
