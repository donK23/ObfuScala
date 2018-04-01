package example

import info.mukel.telegrambot4s.api.declarative.Commands
import info.mukel.telegrambot4s.api.{Polling, TelegramBot}

object ObfuScalaBot extends TelegramBot with Polling with Commands {

  lazy val token = botToken

  onCommand('hello) { implicit msg => // listen on hello
    reply(
      s"""Hello ${msg.from.map(_.firstName).getOrElse("")},
         | I'm a simple bot, written in Scala, which obfuscates
         | ALL THE THINGS!
         |
         | Let's give it a try.
         | Just type in /echo and whatever you want me to obfuscate.
       """.stripMargin)
  }

  onCommand('echo) { implicit msg =>
    reply(???) // FIXME
  }

}

object BotApp extends App {
  ObfuScalaBot.run()
}