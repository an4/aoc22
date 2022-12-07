class Node(_name: String, _type: Type, _parent: Node?) {

    enum class Type {
        DIR,
        FILE
    }

    private val children: HashMap<String, Node> = HashMap()
    private val name: String = _name
    private val type: Type = _type
    private val parent: Node? = _parent
    private var size: Int = -1

    fun addChild(child: Node) {
        val name = child.getName()
        val key = if (child.isFile()) "FILE:$name" else "DIR:$name"
        children.put(key, child)
    }

    fun getChildren(): HashMap<String, Node> {
        return children
    }

    fun getDir(name: String): Node {
        val keyDir = "DIR:$name"
        return children.get(keyDir)!!
    }

    fun getName(): String {
        return name
    }

    fun isFile(): Boolean {
        return type == Type.FILE
    }

    fun setSize(size: Int) {
        this.size = size
    }

    fun getSize(): Int {
        return size
    }

    fun getParent(): Node? {
        return parent
    }
}