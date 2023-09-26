package br.edu.scl.ifsp.ads.havagas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.scl.ifsp.ads.havagas.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        with (amb) {
            adicionarCelularCb.setOnClickListener {
                if(adicionarCelularCb.isChecked) {
                    celularLl.visibility = View.VISIBLE
                } else {
                    celularLl.visibility = View.GONE
                }
            }

            formacaoSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected (parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    when (position) {
                        0, 1 -> {
                            graduacaoEspecializacaoLl.visibility = View.GONE
                            mestradoDoutoradoLl.visibility = View.GONE

                        }
                        2, 3 -> {
                            graduacaoEspecializacaoLl.visibility = View.VISIBLE
                            mestradoDoutoradoLl.visibility = View.GONE
                        }
                        4, 5 -> {
                            graduacaoEspecializacaoLl.visibility = View.VISIBLE
                            mestradoDoutoradoLl.visibility = View.VISIBLE
                        }
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {}
            }

            salvarBt.setOnClickListener {
                var mensagem = ""

                mensagem += "Nome completo: ${nomeCompletoEt.text}\n"
                mensagem += "Email: ${emailEt.text}\n"
                mensagem += "Ingressar na lista de emails: ${if (ingressarListaEmailCb.isChecked) "Sim" else "Não"}\n"
                mensagem += "Telefone: ${telefoneEt.text}\n"
                mensagem += "Tipo do telefone: ${if (comercialRb.isChecked) "Comercial" else "Residencial"}\n"
                if (adicionarCelularCb.isChecked) {
                    mensagem += "Celular: ${celularEt.text}\n"
                }
                mensagem += "Sexo: ${if (masculinoRb.isChecked) "Masculino" else "Feminino"}\n"
                mensagem += "Data de nascimento: ${dataNascimentoEt.text}\n"
                mensagem += "Formação: ${formacaoSp.selectedItem}\n"
                when (formacaoSp.selectedItemPosition) {
                    0, 1 -> {
                        mensagem += "Ano de conclusão: ${anoConclusaoEt.text}\n"
                    }
                    2, 3 -> {
                        mensagem += "Ano de conclusão: ${anoConclusaoEt.text}\n"
                        mensagem += "Instituição: ${instituicaoEt.text}\n"
                    }
                    4, 5 -> {
                        mensagem += "Ano de conclusão: ${anoConclusaoEt.text}\n"
                        mensagem += "Instituição: ${instituicaoEt.text}\n"
                        mensagem += "Título de monografia: ${tituloMonografiaEt.text}\n"
                        mensagem += "Orientador: ${orientadorEt.text}\n"
                    }
                }
                mensagem += "Vagas de interesse: ${vagasInteresseEt.text}"
                Toast.makeText(this@MainActivity, mensagem, Toast.LENGTH_LONG).show()
            }

            limparBt.setOnClickListener {
                nomeCompletoEt.setText("")
                emailEt.setText("")
                ingressarListaEmailCb.isChecked = false
                telefoneEt.setText("")
                comercialRb.isChecked = true
                adicionarCelularCb.isChecked = false
                celularLl.visibility = View.GONE
                celularEt.setText("")
                masculinoRb.isChecked = true
                dataNascimentoEt.setText("")
                formacaoSp.setSelection(0)
                anoConclusaoEt.setText("")
                graduacaoEspecializacaoLl.visibility = View.GONE
                instituicaoEt.setText("")
                mestradoDoutoradoLl.visibility = View.GONE
                tituloMonografiaEt.setText("")
                orientadorEt.setText("")
                vagasInteresseEt.setText("")
            }
        }
    }

    override fun onSaveInstanceState( outState: Bundle) {
        super.onSaveInstanceState(outState)
        with(amb) {
            outState.putString("nomeCompletoEt", nomeCompletoEt.text.toString())
            outState.putString("emailEt", emailEt.text.toString())
            outState.putBoolean("ingressarListaEmailCb", ingressarListaEmailCb.isChecked)
            outState.putString("telefoneEt", telefoneEt.text.toString())
            outState.putBoolean("tipoTelefone", comercialRb.isChecked)
            outState.putBoolean("adicionarCelularCb", adicionarCelularCb.isChecked)
            outState.putInt("celularLl", celularLl.visibility)
            outState.putString("celularEt", celularEt.text.toString())
            outState.putBoolean("sexo", masculinoRb.isChecked)
            outState.putString("dataNascimentoEt", dataNascimentoEt.text.toString())
            outState.putInt("formacaoSp", formacaoSp.selectedItemPosition)
            outState.putString("anoConclusaoEt", anoConclusaoEt.text.toString())
            outState.putString("instituicaoEt", instituicaoEt.text.toString())
            outState.putString("tituloMonografiaEt", tituloMonografiaEt.text.toString())
            outState.putString("orientadorEt", orientadorEt.text.toString())
            outState.putString("vagasInteresseEt", vagasInteresseEt.text.toString())
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        with(amb) {
            nomeCompletoEt.setText(savedInstanceState.getString("nomeCompletoEt"))
            emailEt.setText(savedInstanceState.getString("emailEt"))
            ingressarListaEmailCb.isChecked = savedInstanceState.getBoolean(("ingressarListaEmailCb"))
            telefoneEt.setText(savedInstanceState.getString("telefoneEt"))
            if (savedInstanceState.getBoolean("tipoTelefone")) comercialRb.isChecked else residencialRb.isChecked
            adicionarCelularCb.isChecked = savedInstanceState.getBoolean("adicionarCelularCb")
            celularLl.visibility = savedInstanceState.getInt("celularLl")
            celularEt.setText(savedInstanceState.getString("celularEt"))
            if (savedInstanceState.getBoolean("sexo")) masculinoRb.isChecked else femininoRb.isChecked
            dataNascimentoEt.setText(savedInstanceState.getString("dataNascimentoEt"))
            formacaoSp.setSelection(savedInstanceState.getInt("formacaoSp"))
            anoConclusaoEt.setText(savedInstanceState.getString("anoConclusaoEt"))
            instituicaoEt.setText(savedInstanceState.getString("instituicaoEt"))
            tituloMonografiaEt.setText(savedInstanceState.getString("tituloMonografiaEt"))
            orientadorEt.setText(savedInstanceState.getString("orientadorEt"))
            vagasInteresseEt.setText(savedInstanceState.getString("vagasInteresseEt"))
        }
    }
}
