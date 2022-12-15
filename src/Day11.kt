import java.math.BigInteger

fun main() {
    fun getNewWorryLevel(monkey: Int, worryLevel: Int): Int {
        return when(monkey) {
            0 -> (worryLevel * 5) / 3
            1 -> (worryLevel + 6) / 3
            2 -> (worryLevel + 5) / 3
            3 -> (worryLevel + 2) / 3
            4 -> (worryLevel * 7) / 3
            5 -> (worryLevel + 7) / 3
            6 -> (worryLevel + 1) / 3
            7 -> (worryLevel * worryLevel) / 3
            else -> 0
        }
    }

    fun getNewWorryLevel(monkey: Int, worryLevel: BigInteger, modulo: BigInteger): BigInteger {
        return when(monkey) {
            0 -> worryLevel.multiply(5.toBigInteger()).mod(modulo)
            1 -> worryLevel.add(6.toBigInteger()).mod(modulo)
            2 -> worryLevel.add(5.toBigInteger()).mod(modulo)
            3 -> worryLevel.add(2.toBigInteger()).mod(modulo)
            4 -> worryLevel.multiply(7.toBigInteger()).mod(modulo)
            5 -> worryLevel.add(7.toBigInteger()).mod(modulo)
            6 -> worryLevel.add(1.toBigInteger()).mod(modulo)
            7 -> worryLevel.multiply(worryLevel).mod(modulo)
            else -> {
                throw Exception("Monkey index not found")
                0.toBigInteger()
            }
        }
    }

    fun getNewWorryLevel(monkey: Int, worryLevel: Int, modulo: Int): Int {
        return when(monkey) {
            0 -> (worryLevel * 5) % modulo
            1 -> (worryLevel + 6) % modulo
            2 -> (worryLevel + 5) % modulo
            3 -> (worryLevel + 2) % modulo
            4 -> (worryLevel * 7) % modulo
            5 -> (worryLevel + 7) % modulo
            6 -> (worryLevel + 1) % modulo
            7 -> (worryLevel * worryLevel) % modulo
            else -> 0
        }
    }

    fun part1(): Int {
        val monkeys = arrayOf(arrayListOf(66, 71, 94), arrayListOf(70), arrayListOf(62, 68, 56, 65, 94, 78), arrayListOf(89, 94, 94, 67), arrayListOf(71, 61, 73, 65, 98, 98, 63), arrayListOf(55, 62, 68, 61, 60), arrayListOf(93, 91, 69, 64, 72, 89, 50, 71), arrayListOf(76, 50))
        val itemsCount = IntArray(monkeys.size)
        val passIfTrue =  arrayOf(7, 3, 3, 7, 5, 2, 5, 4)
        val passIfFalse = arrayOf(4, 0, 1, 0, 6, 1, 2, 6)
        val test = arrayOf(3, 17, 2, 19, 11, 5, 13, 7)

        for (round in 0 until 20) {
            for (m in monkeys.indices) {
                for (worryLevel in monkeys[m]) {
                    itemsCount[m]++
                    val newWorryLevel = getNewWorryLevel(m, worryLevel)
                    if (newWorryLevel % test[m] == 0) {
                        monkeys[passIfTrue[m]].add(newWorryLevel)
                    } else {
                        monkeys[passIfFalse[m]].add(newWorryLevel)
                    }
                }
                monkeys[m].clear()
            }
        }

        itemsCount.sort()
        return itemsCount[itemsCount.size-2] * itemsCount[itemsCount.size-1]
    }

    fun part2(): Long {
        val monkeys = arrayOf(
            arrayListOf(66.toBigInteger() , 71.toBigInteger(), 94.toBigInteger()),
            arrayListOf(70.toBigInteger()),
            arrayListOf(62.toBigInteger(), 68.toBigInteger(), 56.toBigInteger(), 65.toBigInteger(), 94.toBigInteger(), 78.toBigInteger()),
            arrayListOf(89.toBigInteger(), 94.toBigInteger(), 94.toBigInteger(), 67.toBigInteger()),
            arrayListOf(71.toBigInteger(), 61.toBigInteger(), 73.toBigInteger(), 65.toBigInteger(), 98.toBigInteger(), 98.toBigInteger(), 63.toBigInteger()),
            arrayListOf(55.toBigInteger(), 62.toBigInteger(), 68.toBigInteger(), 61.toBigInteger(), 60.toBigInteger()),
            arrayListOf(93.toBigInteger(), 91.toBigInteger(), 69.toBigInteger(), 64.toBigInteger(), 72.toBigInteger(), 89.toBigInteger(), 50.toBigInteger(), 71.toBigInteger()),
            arrayListOf(76.toBigInteger(), 50.toBigInteger()))
        val itemsCount = LongArray(monkeys.size)
        val passIfTrue =  arrayOf(7, 3, 3, 7, 5, 2, 5, 4)
        val passIfFalse = arrayOf(4, 0, 1, 0, 6, 1, 2, 6)
        val test = arrayOf(3, 17, 2, 19, 11, 5, 13, 7)

        for (round in 0 until 10000) {
            for (m in monkeys.indices) {
                for (worryLevel in monkeys[m]) {
                    itemsCount[m]++
                    val newWorryLevel = getNewWorryLevel(m, worryLevel, 9699690.toBigInteger())
                    if (newWorryLevel.mod(test[m].toBigInteger()).equals(0.toBigInteger())) {
                        monkeys[passIfTrue[m]].add(newWorryLevel)
                    } else {
                        monkeys[passIfFalse[m]].add(newWorryLevel)
                    }
                }
                monkeys[m].clear()
            }
        }

        val top = itemsCount.sortedDescending().take(2)
        return top[0] * top[1]
    }

    println(part1())
    println(part2())
}