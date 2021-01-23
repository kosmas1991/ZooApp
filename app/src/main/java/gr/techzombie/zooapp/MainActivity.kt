package gr.techzombie.zooapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var adapter:AnimalsAdapter?=null
        var listOfAnimals = ArrayList<Animal>()
        listOfAnimals.add(Animal("Baboon","Baboon lives at the zoo with other animals",R.drawable.baboon))
        listOfAnimals.add(Animal("Bulldog","Bulldog lives at the zoo with other animals",R.drawable.bulldog))
        listOfAnimals.add(Animal("Panda","Panda lives at the zoo with other animals",R.drawable.panda))
        listOfAnimals.add(Animal("Swallow bird","Swallow bird lives at the zoo with other animals",R.drawable.swallow_bird))
        listOfAnimals.add(Animal("White tiger","White tiger lives at the zoo with other animals",R.drawable.white_tiger))
        listOfAnimals.add(Animal("Zebra","Zebra lives at the zoo with other animals",R.drawable.zebra))
        adapter= AnimalsAdapter(this,listOfAnimals)
        tvListAnimal.adapter = adapter
    }

    class AnimalsAdapter:BaseAdapter{
        var context:Context?=null
        var listOfAnimals=ArrayList<Animal>()
        constructor(context:Context, listOfAnimals:ArrayList<Animal>):super(){
            this.listOfAnimals = listOfAnimals
            this.context=context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var animal = listOfAnimals[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflator.inflate(R.layout.animal_ticket,null)
            myView.image.setImageResource(animal.image!!)
            myView.title.text = animal.name
            myView.description.text = animal.des
            return myView
        }

        override fun getItem(position: Int): Any {
            return listOfAnimals[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listOfAnimals.size
        }
    }
}
