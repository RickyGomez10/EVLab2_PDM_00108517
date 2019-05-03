package com.example.evlabo2_00108517

import android.media.Image
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.evlabo2_00108517.Fragmentos.ImagenFragment
import com.example.evlabo2_00108517.Fragmentos.Interface.IComunicaFragments

class MainActivity : AppCompatActivity(), ImagenFragment.OnFragmentInteractionListener, IComunicaFragments {

    val FragmentoImagen = ImagenFragment()


    override fun onFragmentInteraction(uri: Uri) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun enviarImagen(img: Int) {
        val bundle  = Bundle()
        bundle.putSerializable("objeto", img)
        FragmentoImagen.arguments = bundle

        val fragmento : Fragment?= supportFragmentManager.findFragmentById(R.id.ContenedorFragments)
        if (fragmento is ImagenFragment) {
            val fragmento2 : Fragment?= supportFragmentManager.findFragmentByTag("fradDetalle")
            supportFragmentManager.beginTransaction().remove(fragmento2!!).commit()
        }

       supportFragmentManager.beginTransaction().add(R.id.ContenedorFragments, FragmentoImagen, "fragDetalle").commit()
    }

}
