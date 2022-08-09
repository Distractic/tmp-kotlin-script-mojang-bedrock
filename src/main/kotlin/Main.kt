fun main() {
    world.events.beforeChat.subscribe { event ->
        val form = ModalFormData().apply {
            title("Hello")
            textField("Text Field",  "Type something here")
            dropdown("Dropdown", arrayOf("Opt1", "Opt 2", "Opt 3"))
        }
        form.show(event.sender)
        event.cancel = true
    }
}