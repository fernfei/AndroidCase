package com.banshion.shoesmall

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private val shoes = mutableListOf<Shoes>(
            Shoes("2016春秋新款真皮女靴松紧带中跟短靴尖头切尔西靴及踝靴", R.drawable.shoes_01, 100.00),
            Shoes("冬季中年妈妈鞋加绒棉鞋真皮中筒靴粗跟中跟圆头侧拉链女式皮靴子", R.drawable.shoes_02, 200.00),
            Shoes("2016新款粗跟防水台高跟鞋拉链款圆头女靴超高跟短靴时装靴及踝靴", R.drawable.shoes_03, 300.00),
            Shoes("2016短靴春秋新款女靴韩版英伦侧拉链磨砂皮中跟单鞋女鞋及踝靴潮", R.drawable.shoes_04, 400.00),
            Shoes("2015秋冬新款长靴高筒靴超高跟女靴磨砂圆头防水台粗跟及膝骑士靴", R.drawable.shoes_05, 500.00),
            Shoes("2015欧美新款秋季冬天鞋子长筒靴过膝长靴子高跟细跟性感女靴大码", R.drawable.shoes_06, 600.00),
            Shoes("春秋新款内增高女鞋厚底高帮鞋韩版潮运动鞋休闲旅游鞋学生鞋单鞋", R.drawable.shoes_07, 700.00),
            Shoes("2015新款真皮厚底高帮内增高女鞋棉鞋休闲运动鞋冬季加绒潮", R.drawable.shoes_08, 800.00),
            Shoes("2016年真皮韩版内增高单鞋棉鞋女魔术贴休闲鞋运动鞋子牛皮高帮鞋", R.drawable.shoes_09, 900.00),
            Shoes("2016春秋高帮鞋单鞋厚底运动女鞋隐形内增高韩版魔术贴休闲鞋子潮", R.drawable.shoes_10, 1000.00),
            Shoes("2015秋季新品韩版魔术贴松糕厚底高帮女鞋隐形内增高鞋休闲鞋", R.drawable.shoes_11, 1100.00),
            Shoes("2016春款休闲运动旅游鞋隐形内增高帮松糕底透气鞋", R.drawable.shoes_12, 1200.00),
            Shoes("真皮女凉鞋坡跟水钻花朵女凉拖鞋粗跟鱼嘴凉鞋高跟鞋", R.drawable.shoes_13, 1300.00),
            Shoes("2016春夏韩版新款水钻凉鞋真皮镶钻鞋性感女鞋鱼嘴高跟鞋宴会婚鞋", R.drawable.shoes_14, 1400.00),
            Shoes("2016夏女童凉鞋女大童鱼嘴高跟鞋舞蹈鞋公主凉鞋小女孩学生凉鞋", R.drawable.shoes_15, 1500.00),
            Shoes("2016夏季新款坡跟凉鞋高跟防水台鱼嘴鞋厚底松糕鞋", R.drawable.shoes_16, 1600.00),
            Shoes("2016夏季粗跟女凉鞋 韩版超高跟中空丁字扣防水台鱼嘴显瘦罗马鞋", R.drawable.shoes_17, 1700.00),
            Shoes("2016春季鱼嘴高跟鞋春夏新款细跟凉鞋防水台蕾丝女鞋夜店超高跟鞋", R.drawable.shoes_18, 1800.00),
            Shoes("2016春款隐形内增高帆布女鞋10cm韩版松糕厚底学院黑色休闲高帮鞋", R.drawable.shoes_19, 1900.00),
            Shoes("2016春季新款韩版高帮帆布鞋女布鞋平底休闲鞋魔术贴学生鞋小白鞋", R.drawable.shoes_20, 2000.00),
            Shoes("一脚蹬学生懒人套脚厚底牛筋底休闲鞋高跟女鞋", R.drawable.shoes_21, 2100.00),
            Shoes("欧美**水晶坡跟秋鞋女2015新款裸色防水台高跟鞋", R.drawable.shoes_22, 2200.00),
            Shoes("欧美尖头浅口真皮高跟鞋细跟性感个性单鞋红色婚鞋防水台百搭女鞋", R.drawable.shoes_23, 2300.00),
            Shoes("尖头高跟鞋细跟浅口OL真皮性感2016春季新款欧美明星同款黑色单鞋", R.drawable.shoes_24, 2400.00),
            Shoes("2016春夏新款尖头高跟鞋韩版一字扣细跟单鞋真皮中跟白色工作女鞋", R.drawable.shoes_25, 2500.00),
            Shoes("2016春秋尖头单鞋大号真皮黑色绑带高跟鞋中跟细跟性感大码女鞋", R.drawable.shoes_26, 2600.00),
            Shoes("春季新款单鞋扣带浅口细跟超高跟鞋办公室四季鞋防水台", R.drawable.shoes_27, 2700.00)
    )
    private val shoesList = ArrayList<Shoes>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
        }
        navView.setCheckedItem(R.id.navCall)
        navView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawers()
            true
        }
        searchView.setOnSearchClickListener {
            mallTitle.visibility= View.GONE
        }
        searchView.setOnCloseListener {
            mallTitle.visibility = View.VISIBLE
           false
        }


        fab.setOnClickListener {
            Snackbar.make(it, "Data deleted", Snackbar.LENGTH_SHORT)
                .setAction("Undo") {
                    Toast.makeText(this, "Data restored", Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        initFruits()
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        val adapter = ShoesAdapter(this, shoesList)
        recyclerView.adapter = adapter

        swipeRefresh.setColorSchemeResources(R.color.colorPrimary)
        swipeRefresh.setOnRefreshListener {
            refreshFruits(adapter)
        }
    }
    private fun refreshFruits(adapter: ShoesAdapter) {
        thread {
            Thread.sleep(2000)
            runOnUiThread {
                initFruits()
                adapter.notifyDataSetChanged()
                swipeRefresh.isRefreshing = false
            }
        }
    }
    private fun initFruits() {
        shoesList.clear()
        repeat(50) {
            val index = (0 until shoes.size).random()
            shoesList.add(shoes[index])
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> Toast.makeText(this, "You clicked Settings",
                Toast.LENGTH_SHORT).show()
            android.R.id.home -> drawerLayout.openDrawer(GravityCompat.START)
        }
        return true
    }
}

