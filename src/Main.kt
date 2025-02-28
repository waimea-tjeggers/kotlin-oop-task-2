/**
 * ================================================
 * Task 2 - Gnome Fight Club
 *
 * The gnomes have started a fight club!
 *
 *    /\        /\
 *   ('')  VS  (oo)
 * __{__}______{__}__
 *
 * - Gnomes have a strength value from 1-10
 * - Gnomes have a health level from 0-100
 * - Gnomes can train to increase strength
 * - When gnomes fight, they both lose health based
 *   on the strength of the opponent
 * - Gnomes die when health is zero
 * ================================================
 */


fun main() {
    println("Gnome Fight Club")
    println("------------------------")

    // Instantiate gnomes

    val jim = Gnome("Jim", 3)
    val sam = Gnome("Sam", 3)
    val amy = Gnome("Amy", 1)

    println("------------------------")

    println(jim.info())
    println(sam.info())
    println(amy.info())

    check(jim.info() == "Jim: strength 3, health 100")
    check(sam.info() == "Sam: strength 3, health 100")
    check(amy.info() == "Amy: strength 1, health 100")

    check(jim.alive())
    check(sam.alive())
    check(amy.alive())

    // Training time!

    println("------------------------")

    jim.train(2)        // Should increase strength by 1
    println(jim.info())
    check(jim.strength == 4)

    sam.train(7)        // Should increase strength by 3
    println(sam.info())
    check(sam.strength == 6)

    amy.train(24)       // Should increase strength to max
    println(amy.info())
    check(amy.strength == 10)

    // Fight time!

    println("------------------------")

    // Jim vs Amy - Round 1
    jim.fight(amy)

    println(jim.info())
    println(amy.info())

    check(jim.health == 50)     // Lost 5*10 health
    check(amy.health == 80)     // Lost 5*4 health
    check(jim.alive())          // Both still alive
    check(amy.alive())

    println("------------------------")

    // Jim vs Amy - Round 2
    jim.fight(amy)

    println(jim.info())
    println(amy.info())

    check(jim.health == 0)       // Lost 5*10 health
    check(amy.health == 60)      // Lost 5*4 health
    check(jim.alive() == false)  // Died!
    check(amy.alive())           // Alive still

    println("------------------------")

    // Jim vs Amy - Round 3 (but Jim is dead!)
    amy.fight(jim)

    println(jim.info())
    println(amy.info())

    check(jim.health == 0)      // Already at zero!
    check(amy.health == 60)     // Lost no health as dead can't fight back!

    println("------------------------")

    // Sam vs Amy - Round 1
    sam.fight(amy)

    println(sam.info())
    println(amy.info())

    check(sam.health == 50)     // Lost 5*10 health
    check(amy.health == 30)     // Lost 5*6 health
    check(sam.alive())          // Both alive still
    check(amy.alive())

    println("------------------------")

    // Sam vs Amy - Round 2 - The end!
    sam.fight(amy)

    println(sam.info())
    println(amy.info())

    check(sam.health == 0)       // Lost 5*10 health
    check(amy.health == 0)       // Lost 5*6 health
    check(sam.alive() == false)  // Killed each other!
    check(amy.alive() == false)
}


/**
 * Gnome class
 */
class Gnome(val name: String, var strength: Int) {
    var health = 100

    init {
        println("Creating a gnome... $name")
    }

    /**
     * Show info about the gnome, including its
     * health and strength levels in the form:
     *   NAME: strength N, health NNN
     * But if dead (health is zero):
     *   NAME: dead!
     */
    fun info(): String {
        return "$name: strength $strength, health $health"
    }

    /**
     * A gnome is alive if its health > zero
     */
    fun alive(): Boolean {
        if (health > 0 ) return true
        else return false
    }

    /**
     * Training increases the gnome's strength,
     * raising it one level for every two hours
     * of training (rounding down, so 3hrs adds 1)
     * Note: max strength is 10
     */
    fun train(numHours: Int) {
        println("$name trains for $numHours hours...")
        strength = strength + numHours / 2
        if (strength > 10 ) strength = 10


    }

    /**
     * Fighting another gnome impacts the health
     * and strength of both gnomes based on these
     * formula:
     *   health loss = 5 * opponent strength
     * Note: min health is zero!
     */
    fun fight(opponent: Gnome) {
        println("$name vs ${opponent.name}...")
        var damageToOpponent = 0
        var damageToSelf = 0
        if (health >0){
            damageToOpponent = strength * 5
        }


        if (opponent.health >  0 ){
            damageToSelf = opponent.strength * 5
        }

        opponent.health = opponent.health - damageToOpponent
        health = health - damageToSelf
        if (health <0) health = 0
        if (opponent.health < 0 )opponent.health = 0


    }

}

