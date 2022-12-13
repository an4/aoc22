fun main() {
    fun getSignalStrength(cycle: Int, x: Int):Int {
        if (cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220) {
            return cycle * x
        }
        return 0
    }

    fun part1(instructions: List<String>): Int {
        var x = 1
        var cycle = 0
        var signalStrength = 0
        for (instruction in instructions) {
            if (instruction == "noop") {
                cycle++
                signalStrength += getSignalStrength(cycle, x)
            } else {
                val value = instruction.split(" ")[1].toInt()
                cycle++
                signalStrength += getSignalStrength(cycle, x)
                cycle++
                signalStrength += getSignalStrength(cycle, x)
                x += value
            }
        }
        return signalStrength
    }

    fun drawPixel(cycle: Int, sprite: Int, crt: CharArray) {
        if (cycle%40 == sprite || cycle%40 == sprite + 1 || cycle%40 == sprite + 2) {
            crt[cycle-1] = '▓'
        } else  {
            crt[cycle-1] = ' '
        }
    }

    fun part2(instructions: List<String>): Int {
        val crt = CharArray(240)
        var cycle = 0
        var sprite = 1
        for (instruction in instructions) {
            if (instruction == "noop") {
                cycle++
                drawPixel(cycle, sprite, crt)
            } else {
                val value = instruction.split(" ")[1].toInt()
                cycle++
                drawPixel(cycle, sprite, crt)
                cycle++
                drawPixel(cycle, sprite, crt)
                sprite += value
            }
        }

        for (i in crt.indices) {
            if (i % 40 == 0) {
                println()
            }
            print(crt[i])
        }
        return instructions.size
    }

    val rawInput = "noop,noop,addx 5,addx 21,addx -16,noop,addx 1,noop,noop,addx 4,addx 1,addx 4,addx 1,noop,addx 4,addx -9,noop,addx 19,addx -5,noop,noop,addx 5,addx 1,addx -38,addx 5,addx -2,addx 2,noop,noop,addx 7,addx 9,addx 20,addx -3,addx -18,addx 2,addx 5,noop,noop,addx -2,noop,noop,addx 7,addx 3,addx -2,addx 2,addx -28,addx -7,addx 5,noop,addx 2,addx 32,addx -27,noop,noop,noop,noop,noop,addx 7,noop,addx 22,addx -19,noop,addx 5,noop,addx -7,addx 17,addx -7,noop,addx -20,addx 27,noop,addx -16,addx -20,addx 1,noop,addx 3,addx 15,addx -8,addx -2,addx -6,addx 14,addx 4,noop,noop,addx -17,addx 22,noop,addx 5,noop,noop,noop,addx 2,noop,addx 3,addx -32,addx -5,noop,addx 4,addx 3,addx -2,addx 34,addx -27,addx 5,addx 16,addx -18,addx 7,noop,addx -2,addx -1,addx 8,addx 14,addx -9,noop,addx -15,addx 16,addx 2,addx -35,noop,noop,noop,noop,addx 3,addx 4,noop,addx 1,addx 4,addx 1,noop,addx 4,addx 2,addx 3,addx -5,addx 19,addx -9,addx 2,addx 4,noop,noop,noop,noop,addx 3,addx 2,noop,noop,noop"
//    val rawInput = "addx 15,addx -11,addx 6,addx -3,addx 5,addx -1,addx -8,addx 13,addx 4,noop,addx -1,addx 5,addx -1,addx 5,addx -1,addx 5,addx -1,addx 5,addx -1,addx -35,addx 1,addx 24,addx -19,addx 1,addx 16,addx -11,noop,noop,addx 21,addx -15,noop,noop,addx -3,addx 9,addx 1,addx -3,addx 8,addx 1,addx 5,noop,noop,noop,noop,noop,addx -36,noop,addx 1,addx 7,noop,noop,noop,addx 2,addx 6,noop,noop,noop,noop,noop,addx 1,noop,noop,addx 7,addx 1,noop,addx -13,addx 13,addx 7,noop,addx 1,addx -33,noop,noop,noop,addx 2,noop,noop,noop,addx 8,noop,addx -1,addx 2,addx 1,noop,addx 17,addx -9,addx 1,addx 1,addx -3,addx 11,noop,noop,addx 1,noop,addx 1,noop,noop,addx -13,addx -19,addx 1,addx 3,addx 26,addx -30,addx 12,addx -1,addx 3,addx 1,noop,noop,noop,addx -9,addx 18,addx 1,addx 2,noop,noop,addx 9,noop,noop,noop,addx -1,addx 2,addx -37,addx 1,addx 3,noop,addx 15,addx -21,addx 22,addx -6,addx 1,noop,addx 2,addx 1,noop,addx -10,noop,noop,addx 20,addx 1,addx 2,addx 2,addx -6,addx -11,noop,noop,noop"
    val input = rawInput.split(",")
    println(part1(input))
    println(part2(input))
}