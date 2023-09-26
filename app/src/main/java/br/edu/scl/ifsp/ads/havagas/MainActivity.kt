package br.edu.scl.ifsp.ads.havagas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
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
                override fun onItemSelected (
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
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
        }
    }
}
