package de.flerbuster.commandApi

import de.flerbuster.commandApi.command.builders.CommandBuilder
import de.flerbuster.commandApi.command.commands.MessageCommand
import de.flerbuster.commandApi.command.builders.MessageCommandBuilder
import dev.kord.core.Kord
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
fun messageCommand(
    name: String,
    description: String,
    kord: Kord,
    register: Boolean = true,
    builder: CommandBuilder<MessageCommand>.() -> Unit
): MessageCommand {
    val command = MessageCommandBuilder(name.lowercase() , description, kord).apply(builder).build()
    if (register) command.register()
    return command
}
