package ui

import javax.swing.*
import model.*;

class MyWindow : JFrame("Exercise") {
    var table : JTable
    var scrollPane : JScrollPane


    init {
        this.table = JTable(MyTableModel())
        this.scrollPane = JScrollPane(table)
        add(this.scrollPane)

        pack()
        setVisible(true)
    }
}