import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.banshion.uibestpractice.Msg
import com.banshion.uibestpractice.MsgAdapter
import com.banshion.uibestpractice.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity1 : AppCompatActivity(), View.OnClickListener {

    private val msgList = ArrayList<Msg>()

    private lateinit var adapter: MsgAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMsg()
        val layoutManager = LinearLayoutManager(this)
        recycleView.layoutManager = layoutManager
        //用于判断adapter变量是否已经初始化
        if (!::adapter.isInitialized) {
            adapter = MsgAdapter(msgList)
        }
        recycleView.adapter = adapter
        send.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            send -> {
                val content = inputText.text.toString()
                if (content.isNotEmpty()) {
                    val msg = Msg(content, Msg.TYPE_SENT)
                    msgList.add(msg)
                    adapter?.notifyItemInserted(msgList.size - 1) // 当有新消息时， 刷新RecyclerView中的显示
                    recycleView.scrollToPosition(msgList.size - 1)  // 将RecyclerView 定位到最后一行
                    inputText.setText("") // 清空输入框中的内容
                }
            }
        }
    }

    private fun initMsg() {
        val msg1 = Msg("Hello guy.", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello. Who is that?", Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }

}