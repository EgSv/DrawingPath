package ru.startandroid.develop.drawingpath

import android.content.Context
import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(DrawView(this))
    }

    /*internal inner class DrawView(context: Context?): View(context) {
        private var p: Paint = Paint()
        private var rectF: RectF
        private var path: Path
        private var path1: Path

        init {
            p.strokeWidth = 3f
            p.style = Paint.Style.STROKE
            rectF = RectF(350f,100f,400f,150f)
            path = Path()
            path1 = Path()
        }

        override fun onDraw(canvas: Canvas?) {
            canvas!!.drawARGB(80, 102, 204, 255)

            path.reset()

            path.moveTo(100f, 100f)
            path.lineTo(150f, 200f)
            path.lineTo(50f, 200f)

            path.moveTo(250f, 100f)
            path.lineTo(300f,200f)
            path.lineTo(200f, 200f)
            path.close()

            path.addRect(rectF, Path.Direction.CW)
            path.addCircle(450f, 150f, 25f, Path.Direction.CW)

            p.color = Color.BLACK
            canvas.drawPath(path, p)

            path1.reset()

            path1.moveTo(50f, 50f)
            path1.lineTo(500f, 250f)
            path1.moveTo(500f, 50f)
            path1.lineTo(50f, 250f)

            p.color = Color.GREEN
            canvas.drawPath(path1, p)

            path.addPath(path1)

            path.offset(500f, 100f)

            p.color = Color.BLUE
            canvas.drawPath(path, p)
        }
    }

     */

    /*internal inner class DrawView(context: Context): View(context) {
        private var p: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
        private var path: Path
        private var point1: Point
        private var point21: Point
        private var point22: Point

        init {
            p.strokeWidth = 3f
            path = Path()

            point1 = Point(200, 300)
            point21 = Point(500, 600)
            point22 = Point(900, 200)
        }

        override fun onDraw(canvas: Canvas) {
            canvas.drawARGB(80, 102, 204, 255)

            p.color = Color.BLACK
            canvas.drawLine(100f, 100f, 600f, 100f, p)

            p.style = Paint.Style.FILL
            p.color = Color.GREEN
            canvas.drawCircle(point1.x.toFloat(), point1.y.toFloat(), 10f, p)

            path.reset()
            path.moveTo(100f, 100f)
            path.quadTo(point1.x.toFloat(), point1.y.toFloat(), 600f, 100f)
            p.style = Paint.Style.STROKE
            canvas.drawPath(path, p)

            p.color = Color.BLACK
            canvas.drawLine(400f, 400f, 1100f, 400f, p)

            p.style = Paint.Style.FILL
            p.color = Color.BLUE
            canvas.drawCircle(point21.x.toFloat(), point21.y.toFloat(), 10f, p)
            canvas.drawCircle(point22.x.toFloat(), point22.y.toFloat(), 10f, p)

            path.reset()
            path.moveTo(400f, 400f)
            path.cubicTo(point21.x.toFloat(), point21.y.toFloat(), point22.x.toFloat(), point22.y.toFloat(), 1100f, 400f)
            p.style = Paint.Style.STROKE
            canvas.drawPath(path, p)
        }
    }

     */

    internal inner class DrawView(context: Context): View(context) {
        private var p: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
        private var path: Path
        private var text: String

        init {
            p.strokeWidth = 1f
            p.textSize = 20f
            path = Path()
            text = "Draw the text, with origin at (x,y), using the specified paint"
        }

        override fun onDraw(canvas: Canvas) {
            canvas.drawARGB(80, 102, 204, 255)

            path.reset()
            path.addCircle(200f, 200f, 100f, Path.Direction.CW)
            p.color = Color.BLACK
            canvas.drawTextOnPath(text, path, 0f, 0f, p)

            path.reset()
            path.addCircle(500f, 200f, 100f, Path.Direction.CCW)

            p.style = Paint.Style.FILL
            p.color = Color.BLUE
            canvas.drawTextOnPath(text, path, 0f, 0f, p)
            p.style = Paint.Style.STROKE
            canvas.drawPath(path, p)

            path.offset(-300f, 250f)
            p.style = Paint.Style.FILL
            p.color = Color.GREEN
            canvas.drawTextOnPath(text, path, 100f, 0f, p)
            p.style = Paint.Style.STROKE
            canvas.drawPath(path, p)

            path.offset(300f, 0f)
            p.style = Paint.Style.FILL
            p.color = Color.RED
            canvas.drawTextOnPath(text, path, 0f, 30f, p)
            p.style = Paint.Style.STROKE
            canvas.drawPath(path, p)
        }
    }
}