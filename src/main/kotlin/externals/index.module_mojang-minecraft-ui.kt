@file:Suppress("INTERFACE_WITH_SUPERCLASS", "OVERRIDING_FINAL_MEMBER", "RETURN_TYPE_MISMATCH_ON_OVERRIDE", "CONFLICTING_OVERLOADS")

import kotlin.js.Promise

external open class ActionFormData {
    open fun body(bodyText: String): ActionFormData
    open fun button(text: String, iconPath: String = definedExternally): ActionFormData
    open fun show(player: Player): Promise<ActionFormResponse>
    open fun title(titleText: String): ActionFormData
}

external open class ActionFormResponse : FormResponse {
    override var isCanceled: Boolean
    open var selection: Number
}

external open class FormResponse {
    open var isCanceled: Boolean
}

external open class MessageFormData {
    open fun body(bodyText: String): MessageFormData
    open fun button1(text: String): MessageFormData
    open fun button2(text: String): MessageFormData
    open fun show(player: Player): Promise<MessageFormResponse>
    open fun title(titleText: String): MessageFormData
}

external open class MessageFormResponse : FormResponse {
    override var isCanceled: Boolean
    open var selection: Number
}

external open class ModalFormData {
    open fun dropdown(label: String, options: Array<String>, defaultValueIndex: Number = definedExternally): ModalFormData
    open fun icon(iconPath: String): ModalFormData
    open fun show(player: Player): Promise<ModalFormResponse>
    open fun slider(label: String, minimumValue: Number, maximumValue: Number, valueStep: Number, defaultValue: Number = definedExternally): ModalFormData
    open fun textField(label: String, placeholderText: String, defaultValue: String = definedExternally): ModalFormData
    open fun title(titleText: String): ModalFormData
    open fun toggle(label: String, defaultValue: Boolean = definedExternally): ModalFormData
}

external open class ModalFormResponse : FormResponse {
    open var formValues: Array<Any>
    override var isCanceled: Boolean
}