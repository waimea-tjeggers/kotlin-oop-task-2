/**
 * ================================================
 * Garden Gnomes
 *
 *    /\
 *   ('')
 * __{__}__   /\
 *    #1  |  (oo)
 *        |__{__}__   /\
 *            #2  |  (xx)
 *                |__{__}__
 *                    #3  |
 *
 * Gnomes are placed on some steps in the garden.
 * The top step is #1, the lowest step is #10
 * - Only one gnome can be on a step at a time
 * - Gnomes can be shifted to different steps,
 *   but only if they are unoccupied
 * - Gnomes can be moved up and down the steps,
 *   but not above the top step (1), nor below the
 *   lowest (10)
 * - If Gnomes are moving up/down, and the target
 *   step is occupied, they take the step before
 * ================================================
 */


fun main() {
    println("Gnomes")
    println("------------------------")

    // Creating gnomes

    val jim = Gnome("Jim", 1)
    val sam = Gnome("Sam", 5)
    val amy = Gnome("Amy", 9)

    val gnomes = mutableListOf<Gnome>()
    gnomes.add(jim)
    gnomes.add(sam)
    gnomes.add(amy)

    // Showing gnome info

    for (gnome in gnomes) {
        println(gnome.info())
    }

    check(jim.info() == "Jim is on step 1")
    check(sam.info() == "Sam is on step 5")
    check(amy.info() == "Amy is on step 9")

    // Placing gnomes on new steps

    jim.gotoStep(2, gnomes) // Jump to step 2. Should be fine
    println(jim.info())
    check(jim.step == 2)

    jim.gotoStep(5, gnomes) // Jump to step 5. But it is occupied so should not move
    println(jim.info())
    check(jim.step == 2)

    // Shifting gnomes

    sam.moveUp(4, gnomes)   // Move up to an empty step. Should be fine
    println(sam.info())
    check(sam.step == 1)

    sam.moveUp(1, gnomes)   // Try to move up beyond top step. Should not be possible
    println(sam.info())
    check(sam.step == 1)

    amy.moveDown(5, gnomes) // Try to move down beyond bottom. Should stop at bottom
    println(amy.info())
    check(amy.step == 10)

    jim.moveDown(8, gnomes) // Try to move right to bottom. Occupied, so should stop before
    println(jim.info())
    check(jim.step == 9)

    jim.moveUp(8, gnomes)   // Try to move right to top. Occupied, so should stop before
    println(jim.info())
    check(jim.step == 2)
}


/**
 * Steps class
 */
class Steps() {
    val steps = Array<Gnome?>(10) { null }

    fun placeGnomeOnStep(step: Int, gnome: Gnome) {

    }
}
/**
 * Gnome class
 */
class Gnome(val name: String, var step: Int) {
    init {
        println("Creating a gnome... $name")
    }

    /**
     * Show info about the gnome in the form
     * NAME is on step N
     */
    fun info(): String {
        return ""
    }

    /**
     * Shift the gnome to a given step
     * If the step is occupied, don't move
     */
    fun gotoStep(newStep: Int, allGnomes: List<Gnome>) {

    }

    /**
     * Shift the gnome up the given number of steps
     * If beyond top (1), stop at top. If step is
     * occupied, go down until a free step is found
     */
    fun moveUp(numSteps: Int, allGnomes: List<Gnome>) {

    }

    /**
     * Shift the gnome down the given number of steps
     * If beyond bottom (10), stop at bottom. If step
     * is occupied, go up until a free step is found
     */
    fun moveDown(numSteps: Int, allGnomes: List<Gnome>) {

    }
}

