package com.egci428.singletouch

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.graphics.Paint.Join
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class SingleTouchEventView(context: Context) : View(context) {
        private val paint = Paint()
        private val path = Path()
        private var eventX: Float = 0.toFloat()
        private var eventY: Float = 0.toFloat()
        private var fingerDown = false

        init {

                paint.setAntiAlias(true)
                paint.setStrokeWidth(6f)
                paint.setColor(Color.BLACK)
                paint.setStyle(Paint.Style.STROKE)
                paint.setStrokeJoin(Paint.Join.ROUND)

            }

        protected override fun onDraw(canvas: Canvas) {
                canvas.drawPath(path, paint)
                if (fingerDown) {
                        canvas.drawCircle(eventX, eventY, 20F, paint)
                    }
            }

        override fun onTouchEvent(event: MotionEvent): Boolean {
                eventX = event.x
                eventY = event.y

                when (event.action) {
                        MotionEvent.ACTION_DOWN -> {
                                fingerDown = true
                                path.moveTo(eventX, eventY)

                                return true
                            }
                        MotionEvent.ACTION_MOVE -> path.lineTo(eventX, eventY)
                        MotionEvent.ACTION_UP -> fingerDown = false
                        else -> return false
                    }// nothing to do

                // Schedules a repaint.
                invalidate()
                return true
            }
    }