package com.github.dsaouda.fiap.hack.apostila.page

import com.github.dsaouda.fiap.hack.common.JsoupFactory
import com.github.dsaouda.fiap.hack.common.url
import org.jsoup.Connection
import org.jsoup.nodes.Document

object ArquivosPage {

    fun request(params: List<String>?): Document {
        val conn = JsoupFactory.create(url("/programas/login/alunos_2004/apostilas_2007/_arquivos.asp"))
                .method(Connection.Method.POST)
                .header("X-Requested-With", "XMLHttpRequest")
                .header("X-Prototype-Version", "1.4.0")

        params?.forEach { d ->
            val valor = d.split("=")
            conn.data(valor[0], valor[1])
        }

        return conn.execute().parse()
    }

}