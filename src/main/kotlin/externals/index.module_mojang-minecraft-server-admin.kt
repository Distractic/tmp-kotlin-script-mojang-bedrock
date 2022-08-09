@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

external open class SecretString(value: String) {
    open fun equals(other: SecretString): Boolean
}

external open class ServerSecrets {
    open var names: Array<String>
    open fun get(name: String): SecretString
}

external open class ServerVariables {
    open var names: Array<String>
    open fun get(name: String): Any
}

external var secrets: ServerSecrets

external var variables: ServerVariables