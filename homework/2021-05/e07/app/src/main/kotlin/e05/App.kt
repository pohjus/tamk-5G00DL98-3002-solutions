package e05

import ui.*
import io.readFile
import net.fetchAndParse
import javax.swing.SwingUtilities

fun main(args: Array<String>) {
    SwingUtilities.invokeLater() {
        MyWindow()
    }
}
