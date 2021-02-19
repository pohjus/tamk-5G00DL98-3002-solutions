package ui

import javax.swing.table.AbstractTableModel
import model.Person
import net.*

class MyTableModel : AbstractTableModel() {
    val columns = arrayOf("Name", "BMI")
    var myData = mutableListOf<Person>()

    init {
        fetchAndParseAll() {
            // Todo create proper error message
            this.myData = it!!
            this.fireTableDataChanged()
        }
    }

    override fun getColumnName(column: Int) = columns[column]

    override fun getRowCount() : Int {
        return myData.size
    }
    
    override fun getColumnCount() : Int {
        return 2
    }

    override fun getValueAt(row : Int, column : Int) : String? {
        return if(column == 0) myData[row].name else "${myData[row].bmi}" 
    }
}