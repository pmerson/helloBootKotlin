package pmerson.hello.infra.emailer

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Component

@Component
class Emailer(val mailSender: JavaMailSender) {

    fun send(toAddress: String, subject: String, text: String) {
        var message = SimpleMailMessage()
        message.setTo(toAddress)
        message.setSubject(subject)
        message.setText(text)
        mailSender.send(message)
    }

    fun sendHtml(to: Array<String>, subject: String, text: String,
             isHtml: Boolean) {
        val mail = mailSender.createMimeMessage()
        val helper = MimeMessageHelper(mail, true)
        helper.setTo(to)
        helper.setSubject(subject)
        helper.setText(text, isHtml)

        mailSender.send(mail)
    }

}