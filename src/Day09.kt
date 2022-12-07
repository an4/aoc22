import kotlin.math.abs

fun main() {
    fun buildPoint(x: Int, y: Int): String {
        return "$x:$y"
    }

    fun arePointsTouching(a: Int, b: Int, c: Int, d: Int): Boolean {
        return abs(c-a) <= 1 && abs(b-d) <= 1
    }

    fun movePoint(a: Int, b: Int, c: Int, d: Int): Pair<Int, Int> {
        var x = c
        var y = d
        if (a == c) {
            y = if (b > d) d+1 else d-1
        } else if (b == d) {
            x = if (a > c) c+1 else c-1
        } else {
            x = if (a > c) c+1 else c-1
            y = if (b > d) d+1 else d-1
        }
        return Pair(x, y)
    }

    fun part1(moves: List<String>): Int {
        val positions = HashSet<String>()
        var h_x = 0
        var h_y = 0
        var t_x = 0
        var t_y = 0
        positions.add(buildPoint(t_x, t_y))

        for(move in moves) {
            val parts = move.split(" ")
            val direction = parts[0]
            val distance = parts[1].toInt()

            for(d in 1..distance) {
                when(direction) {
                    "L" -> h_y++
                    "R" -> h_y--
                    "U" -> h_x--
                    "D" -> h_x++
                    else -> {throw Exception("unknown direction")}
                }
                if (!arePointsTouching(h_x, h_y, t_x, t_y)) {
                    val newPosition = movePoint(h_x, h_y, t_x, t_y)
                    positions.add(buildPoint(newPosition.first, newPosition.second))
                    t_x = newPosition.first
                    t_y = newPosition.second
                }
            }
        }
        return positions.size
    }

    fun part2(moves: List<String>): Int {
        val positions = HashSet<String>()
        val points = arrayOf(arrayOf(0,0), arrayOf(0,0), arrayOf(0,0), arrayOf(0,0), arrayOf(0,0), arrayOf(0,0), arrayOf(0,0), arrayOf(0,0), arrayOf(0,0), arrayOf(0,0))
        positions.add(buildPoint(0, 0))

        for(move in moves) {
            val parts = move.split(" ")
            val direction = parts[0]
            val distance = parts[1].toInt()

            for(d in 1..distance) {
                when(direction) {
                    "L" -> points[0][1]++
                    "R" -> points[0][1]--
                    "U" -> points[0][0]--
                    "D" -> points[0][0]++
                    else -> {throw Exception("unknown direction")}
                }
                for (i in 1 until points.size) {
                    if (!arePointsTouching(points[i-1][0], points[i-1][1], points[i][0], points[i][1])) {
                        val newPosition = movePoint(points[i-1][0], points[i-1][1], points[i][0], points[i][1])
                        if (i==9) {
                            positions.add(buildPoint(newPosition.first, newPosition.second))
                        }
                        points[i][0] = newPosition.first
                        points[i][1] = newPosition.second
                    }
                }
            }
        }
        return positions.size
    }

    val rawInput = "L 1,R 1,U 1,R 1,L 1,U 2,L 2,R 1,U 2,D 2,R 2,D 2,R 1,U 1,R 2,L 1,D 1,L 2,R 1,D 1,R 1,U 1,D 1,R 1,D 1,R 1,D 2,L 2,D 1,R 2,L 1,R 2,U 2,R 1,U 1,D 2,U 1,R 1,D 1,R 2,D 1,L 2,R 1,U 1,L 1,U 1,D 1,U 1,D 1,L 1,D 1,R 1,D 2,L 1,D 1,L 1,D 1,R 1,U 1,D 2,R 1,D 1,L 2,D 2,U 1,L 1,U 1,L 1,R 2,U 1,L 1,D 1,R 2,L 2,U 1,D 2,R 1,U 1,R 2,L 2,U 1,L 2,R 2,D 1,L 1,R 1,D 2,L 2,U 1,L 2,R 1,U 2,D 1,U 2,D 2,L 2,D 1,R 1,L 2,R 2,L 2,R 2,L 2,R 2,L 1,U 1,R 2,U 1,D 1,R 2,D 2,R 2,D 2,L 2,R 2,U 3,R 1,U 3,D 3,U 1,L 2,D 2,R 3,D 1,R 3,U 1,L 3,R 3,L 1,U 3,R 3,U 3,R 3,U 2,L 2,D 2,R 3,U 2,L 2,U 3,L 2,R 1,U 3,R 2,U 3,L 2,R 2,U 1,L 3,R 3,L 3,R 2,L 3,D 3,L 2,D 1,R 1,D 3,U 3,R 3,D 2,L 2,D 2,R 1,D 1,U 3,R 1,U 2,L 3,U 3,L 2,D 1,L 3,R 2,D 2,L 2,D 3,L 3,U 1,D 3,U 3,L 3,R 2,D 2,R 3,D 2,R 3,U 2,R 1,L 2,R 2,L 1,D 3,U 2,L 2,U 3,L 1,D 1,L 2,R 3,L 1,D 2,U 1,D 3,U 1,D 3,L 1,U 1,R 3,L 2,U 3,L 3,U 1,L 2,D 1,R 2,L 1,R 2,L 2,D 3,U 2,D 2,U 3,L 4,D 4,R 3,D 4,R 1,L 2,U 2,R 1,U 4,D 4,U 4,D 4,R 4,L 2,U 3,D 1,R 4,D 2,L 2,D 1,L 4,R 3,U 2,D 4,U 3,R 3,L 1,R 1,L 2,D 4,U 2,R 1,L 3,D 3,R 4,U 2,L 1,D 3,R 4,D 2,U 3,D 1,L 2,D 2,R 2,D 3,R 2,U 2,R 1,L 1,U 2,D 2,U 3,D 1,U 3,D 1,R 4,D 2,U 1,L 3,D 4,R 3,D 4,U 2,D 1,R 2,U 3,L 3,D 1,U 2,L 3,D 1,L 3,D 1,U 1,D 4,R 1,D 4,L 2,R 3,D 4,R 2,L 3,D 4,U 3,L 4,U 1,L 3,R 1,L 1,D 2,L 1,U 2,D 3,L 1,R 4,L 1,D 2,U 2,L 3,U 3,L 1,R 4,U 3,D 3,R 1,L 2,R 4,U 2,L 3,U 4,L 2,R 4,D 5,U 1,R 2,D 5,L 5,R 1,D 3,U 3,L 3,U 5,R 1,D 1,R 3,U 3,D 1,R 1,L 4,R 1,L 3,U 4,L 3,R 5,D 3,R 2,U 1,R 2,D 2,L 4,R 2,U 1,L 3,D 4,R 4,L 1,R 3,U 3,D 2,R 3,D 3,U 1,L 5,U 1,L 5,R 5,D 1,U 1,R 5,D 4,L 1,R 4,L 5,D 5,L 2,D 1,L 3,D 5,L 4,R 4,D 1,U 1,D 4,U 1,R 4,L 2,D 4,U 1,L 3,R 3,L 3,R 3,D 2,R 3,L 5,R 1,L 1,R 3,D 5,U 5,L 3,U 3,L 5,D 3,L 2,U 5,D 5,U 5,D 4,U 4,R 5,U 3,D 5,R 1,L 4,U 1,L 4,R 2,D 1,U 4,L 5,D 2,R 1,U 1,R 3,U 1,R 4,U 4,L 1,R 2,U 5,D 2,L 5,U 4,D 2,R 1,D 1,U 6,D 5,L 4,U 5,R 1,L 3,D 2,R 3,U 6,L 2,R 6,D 1,R 5,D 1,L 1,R 2,L 4,R 3,L 4,D 6,R 5,U 1,L 4,D 2,L 2,D 3,L 2,D 5,R 4,D 3,L 2,D 4,R 1,U 5,L 5,U 5,D 2,L 3,D 4,L 3,U 4,L 4,U 6,D 6,U 4,R 2,D 3,U 1,R 4,D 3,R 1,D 2,R 3,L 2,D 2,L 4,D 5,L 5,R 2,L 1,R 2,D 2,R 4,U 4,R 5,L 4,D 1,L 6,R 4,D 2,R 6,L 6,D 3,R 2,D 2,U 4,R 2,U 2,L 2,R 5,D 5,U 6,D 6,L 5,R 1,U 3,L 1,D 1,U 2,R 5,L 2,D 2,U 4,R 2,D 2,U 1,D 2,R 3,L 6,U 1,D 6,R 3,D 6,R 1,D 7,R 7,L 4,R 4,D 5,U 6,R 2,L 3,R 5,L 5,U 6,D 3,U 5,D 3,U 5,R 7,L 5,U 7,L 6,U 5,D 1,L 7,U 6,L 3,D 1,L 6,U 4,D 1,U 1,R 1,L 3,D 6,L 6,R 3,D 3,U 2,R 1,D 6,U 7,R 6,L 4,R 4,D 7,R 1,D 5,U 6,D 4,R 6,L 2,U 4,D 7,R 5,D 6,U 7,R 6,D 6,U 1,D 4,L 2,U 2,R 7,U 1,L 1,U 1,L 7,D 3,U 5,D 5,L 1,D 4,L 3,U 7,L 6,R 7,U 6,R 1,L 3,R 1,D 3,L 7,R 4,L 3,D 2,L 7,D 2,R 5,L 7,D 6,L 6,D 3,L 3,D 5,U 3,L 5,R 6,L 1,U 5,R 4,U 2,D 3,R 5,L 4,U 5,D 7,R 1,L 3,U 5,D 3,L 6,R 2,L 2,U 6,R 3,U 7,R 3,D 1,L 2,U 7,L 6,D 3,L 8,R 6,D 3,L 5,R 5,U 5,R 8,D 7,R 7,U 8,L 5,D 6,R 6,L 6,D 8,U 1,R 4,L 3,R 6,L 6,D 5,R 4,D 8,L 4,R 4,D 3,L 2,U 6,L 8,R 1,U 5,L 4,D 8,R 6,D 5,U 6,L 5,R 1,L 8,U 7,R 6,D 4,U 2,D 8,U 3,D 7,R 6,D 8,R 8,U 8,D 7,L 3,D 4,L 1,U 4,R 4,U 2,D 6,R 1,D 8,R 2,D 4,R 5,L 1,R 7,L 3,D 1,U 1,R 7,U 5,D 1,L 2,R 8,D 8,L 5,U 8,D 4,L 5,D 3,U 2,L 7,R 2,L 5,U 3,R 3,U 6,R 6,D 4,R 3,U 4,D 5,U 6,R 3,L 4,R 5,L 4,R 8,U 6,L 6,U 1,L 5,R 3,U 1,D 5,U 8,R 1,L 2,R 3,L 8,U 6,L 4,R 3,L 3,R 7,L 9,D 5,R 8,L 5,U 7,D 7,R 6,L 8,U 4,D 5,R 8,L 4,R 8,U 9,R 9,L 8,D 9,L 9,D 6,R 1,L 8,U 4,L 6,U 5,R 9,L 5,D 6,R 9,D 9,U 6,L 1,U 8,L 7,R 9,U 4,R 6,U 1,R 5,U 5,L 4,R 4,D 7,L 6,U 3,R 9,U 1,L 6,U 5,L 5,U 2,L 3,U 2,D 6,R 8,L 5,U 4,D 4,R 4,D 6,L 8,U 9,R 4,L 3,D 1,U 2,D 5,U 3,D 3,L 2,D 3,L 4,D 5,L 9,D 9,U 2,D 8,R 4,L 8,R 9,D 7,L 3,D 2,R 2,L 4,D 7,R 6,D 8,R 9,L 3,D 5,U 1,L 8,D 6,R 9,U 6,R 9,D 6,L 9,U 5,D 10,L 4,U 10,R 3,U 7,D 4,L 3,R 8,L 4,U 10,R 8,L 10,U 8,R 5,L 8,U 6,L 5,D 7,L 6,U 6,L 9,R 8,U 6,D 7,L 10,R 2,D 7,L 8,U 5,L 2,D 2,U 7,D 6,R 7,D 2,U 3,R 10,D 2,U 6,D 6,L 8,D 2,L 2,D 10,L 2,D 1,L 10,D 6,R 6,L 7,D 9,R 2,D 5,U 2,R 4,L 4,D 1,L 3,R 10,U 9,L 4,D 10,L 10,D 4,U 2,R 1,L 4,D 6,U 2,L 6,R 4,U 1,L 9,R 7,L 8,U 5,R 1,D 6,L 4,U 9,D 1,L 5,R 10,D 4,L 6,U 8,R 4,L 5,D 10,R 8,D 8,R 4,D 5,R 7,L 10,D 3,R 1,L 4,R 8,L 10,D 2,L 3,D 6,L 8,R 10,L 2,D 8,R 5,L 8,D 1,U 6,D 11,U 7,L 1,U 6,R 9,L 8,R 5,U 9,D 5,L 10,U 6,L 3,D 4,U 6,D 10,L 2,D 9,L 5,R 8,D 1,R 1,U 1,D 4,R 4,U 6,L 9,U 7,R 11,L 8,D 3,R 9,L 11,U 9,L 4,D 10,U 9,L 7,R 9,U 1,R 8,U 4,L 3,U 2,D 7,R 6,U 1,D 10,U 9,R 6,L 6,D 4,U 3,L 10,R 10,U 6,R 8,L 9,R 2,D 7,R 4,U 6,R 2,L 4,D 1,L 10,U 9,R 11,U 11,R 1,D 5,L 8,U 3,R 1,U 4,D 10,U 6,L 8,R 4,L 7,R 8,D 3,L 9,U 4,L 6,R 2,D 2,U 9,D 6,R 8,L 2,U 7,L 2,R 8,L 7,D 5,R 10,U 5,L 10,U 6,R 8,U 9,L 7,D 11,U 10,L 4,D 5,R 4,L 7,U 5,D 8,R 6,D 9,L 4,U 9,R 6,D 1,U 6,R 8,U 10,D 6,U 10,L 3,D 1,L 1,R 9,D 10,L 10,U 12,D 3,L 2,U 6,L 9,U 2,R 6,D 8,R 11,L 1,U 3,R 1,U 9,R 12,U 3,D 11,U 3,D 10,U 12,L 11,R 9,U 9,D 11,L 8,D 4,R 4,U 4,D 1,L 7,R 10,L 4,R 4,U 11,D 3,L 6,R 10,L 9,R 11,U 6,D 2,U 2,L 3,D 11,U 6,D 12,L 5,R 5,D 6,R 5,U 2,R 8,L 7,D 7,R 3,D 8,U 6,D 1,U 1,D 4,L 3,D 12,L 8,D 8,U 7,R 1,D 10,L 5,D 7,L 1,U 4,R 12,L 8,U 2,L 2,U 1,L 8,U 3,L 12,R 3,D 11,R 1,U 4,D 12,L 3,U 2,R 5,U 2,R 7,U 8,L 5,R 1,D 5,R 12,D 8,R 9,D 7,L 2,R 2,U 9,D 6,U 6,R 2,D 2,R 9,D 4,R 12,D 13,R 9,L 3,D 8,L 13,U 2,R 10,U 12,D 12,U 3,L 6,D 8,U 1,L 12,D 9,L 7,R 2,D 4,R 5,L 7,R 12,U 4,L 7,D 4,U 10,L 2,D 1,U 5,R 5,U 2,L 9,D 10,L 1,R 7,L 6,D 1,L 12,R 6,U 10,R 2,D 10,R 5,L 3,R 8,D 1,R 12,L 7,U 5,L 11,D 4,U 11,D 1,U 11,L 1,D 11,U 11,D 4,U 8,R 5,D 6,L 12,R 5,D 10,L 2,D 5,R 10,U 6,D 6,R 4,D 7,L 2,D 5,U 2,R 9,L 11,U 13,D 9,L 11,D 8,L 2,D 4,R 13,L 5,U 12,R 11,U 5,L 8,U 5,D 7,U 1,R 9,D 4,U 3,R 9,L 3,D 7,R 8,D 7,L 2,U 4,L 12,U 13,L 12,R 8,L 3,R 12,L 4,U 12,R 13,D 10,L 8,U 12,R 5,L 1,U 2,L 3,U 2,D 12,L 12,U 11,L 2,R 6,U 3,L 2,R 7,U 7,L 3,R 8,L 11,D 2,U 1,R 12,D 1,R 4,L 13,U 14,R 14,D 12,R 12,D 11,L 11,U 2,L 6,D 8,L 5,D 7,R 2,L 14,U 12,R 13,L 7,D 2,U 4,D 5,R 5,L 7,R 7,U 1,R 10,D 11,L 7,U 2,R 5,L 11,U 11,R 9,U 9,R 12,D 14,R 5,L 9,U 2,D 12,L 6,U 7,R 5,L 10,D 10,U 4,D 13,L 13,D 3,R 8,D 10,U 12,L 14,U 7,D 6,R 4,U 11,R 2,L 5,D 12,R 4,L 4,D 5,L 12,U 3,L 3,U 7,R 4,L 2,R 7,L 5,D 5,R 9,L 5,D 12,R 3,U 1,D 6,U 2,R 10,L 4,U 12,R 15,L 2,R 3,D 8,L 13,D 3,R 5,D 5,L 5,U 7,L 4,R 10,D 11,L 3,R 1,U 4,D 15,L 8,U 10,L 5,D 1,R 5,D 15,R 3,U 9,R 4,D 3,L 15,U 6,D 10,U 2,R 6,U 10,L 12,R 8,D 12,R 14,U 10,D 1,L 1,D 8,U 3,R 11,D 7,L 5,D 14,R 1,D 8,R 6,U 6,D 1,U 14,R 12,L 5,U 5,L 14,U 1,D 3,R 6,U 4,R 9,L 13,R 2,U 10,R 11,U 7,D 8,U 14,L 4,R 3,U 6,R 2,D 14,U 10,D 13,U 8,R 12,L 12,U 6,L 4,U 5,D 6,U 8,L 12,D 1,L 3,R 4,L 11,R 5,D 3,U 6,D 15,R 14,U 8,R 10,U 15,R 13,L 13,U 4,D 3,U 4,D 1,U 5,R 5,D 4,R 2,D 13,R 7,D 10,U 3,R 15,D 3,U 13,R 16,U 2,D 6,L 13,R 8,L 5,R 1,U 7,R 6,U 6,R 10,U 5,L 14,R 12,U 8,R 13,U 4,L 10,R 16,L 15,D 7,R 14,D 8,U 8,L 15,R 2,U 11,L 6,R 6,D 2,U 9,D 12,L 10,U 7,R 8,L 4,D 5,R 13,L 9,U 15,D 11,R 11,D 8,L 10,R 14,D 3,R 10,U 1,R 11,L 16,R 12,D 15,L 13,U 2,L 11,U 15,D 9,R 1,D 13,L 16,U 9,D 2,R 5,U 9,R 11,L 16,U 5,R 11,U 8,L 15,U 1,L 11,U 3,L 4,U 9,L 5,U 11,D 9,U 4,L 14,U 8,L 16,D 9,U 5,L 14,R 13,U 8,L 4,R 9,L 4,R 7,D 15,U 14,D 8,U 6,R 11,L 15,D 10,R 2,L 12,R 11,D 7,R 11,L 4,R 4,D 4,R 3,U 15,L 6,R 8,L 5,U 13,D 6,R 1,D 15,L 9,U 2,L 13,R 10,U 8,R 15,D 16,L 13,U 13,L 12,R 10,U 16,L 10,R 14,D 17,R 4,D 16,U 17,R 8,D 10,R 11,L 10,U 17,L 11,U 3,L 4,U 2,D 10,R 15,U 1,R 5,L 12,D 4,R 1,U 15,R 13,L 17,R 15,D 4,L 14,R 3,D 1,U 14,R 11,D 12,L 7,D 11,R 12,U 1,R 5,L 11,D 9,U 8,R 1,U 4,L 15,R 12,U 17,R 4,U 14,L 4,D 16,R 9,U 9,D 11,L 7,D 16,R 10,L 10,R 15,U 10,R 6,L 4,R 6,L 12,U 9,R 15,D 12,L 14,U 14,D 6,U 4,R 17,U 2,L 5,R 13,D 15,U 13,L 5,D 3,L 7,U 12,R 13,D 15,U 15,L 17,U 17,L 6,R 2,U 17,R 7,L 15,U 17,R 11,L 2,U 1,D 4,U 2,R 10,L 9,D 18,U 5,D 7,R 18,L 11,D 2,U 13,D 12,R 10,D 2,R 9,L 3,D 9,R 9,L 17,R 4,L 7,D 16,L 5,R 3,L 8,U 7,R 8,L 1,D 12,U 13,R 8,D 18,U 7,R 6,D 7,L 7,D 8,R 16,L 13,R 6,U 1,L 9,U 9,L 12,D 13,R 18,L 7,D 18,U 17,R 18,D 11,R 1,D 4,U 3,L 7,D 17,R 8,U 11,D 7,L 4,R 12,U 10,L 15,R 14,U 16,D 4,L 10,U 6,D 18,R 7,U 13,R 11,D 14,L 5,U 5,L 7,R 15,L 16,U 6,D 9,L 17,R 4,L 16,D 10,U 16,D 17,R 7,L 16,U 6,L 15,R 13,U 8,L 14,R 12,U 5,D 17,R 13,D 12,U 12,L 16,R 8,U 4,D 6,U 10,D 14,R 18,L 17,U 15,L 5,U 7,D 15,U 10,R 18,L 11,D 10,R 12,U 15,D 11,U 7,D 3,R 2,U 5,R 12,U 15,R 12,U 19,L 6,U 18,D 8,L 7,D 2,R 1,L 16,D 5,L 9,U 11,L 6,U 7,L 2,D 18,L 1,U 19,D 15,U 8,R 5,U 13,L 7,R 14,U 2,D 10,U 16,D 3,R 8,L 10,D 17,U 16,D 6,R 18,D 5,L 5,D 4,L 6,U 17,D 7,R 15,D 5,R 18,L 6,U 15,L 3,U 13,L 15,R 5,D 9,R 11,U 15,L 19,D 11,L 8,D 14,R 7,L 16,D 5,R 13,D 5,L 9,D 3,L 3,R 12,U 17,R 8,L 11,U 2,R 9,L 3,D 6,L 9,U 11,R 6,U 19,R 6,L 12,U 5,R 4,U 4,L 16,R 17,D 12,U 11,R 4,D 11,U 4,R 8,U 9,R 12,U 13,L 2,D 9,L 2"
//    val rawInput = "R 4,U 4,L 3,D 1,R 4,D 1,L 5,R 2"
    val input = rawInput.split(",")
    println(part1(input))
    println(part2(input))
}