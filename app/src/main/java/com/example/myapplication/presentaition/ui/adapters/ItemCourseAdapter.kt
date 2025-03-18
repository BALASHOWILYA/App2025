package com.example.myapplication.presentaition.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.domain.models.Course

class ItemCourseAdapter(private val courseList: List<Course>) :
    RecyclerView.Adapter<ItemCourseAdapter.CourseViewHolder>() {

    // Класс ViewHolder для хранения ссылок на элементы представления
    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseImage: ImageView = itemView.findViewById(R.id.course_image_id)
        val courseName: TextView = itemView.findViewById(R.id.course_name_id)
        val courseIntro: TextView = itemView.findViewById(R.id.course_intro_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        // Создаем новый ViewHolder с нашим макетом элемента
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        // Получаем данные для текущей позиции
        val currentItem = courseList[position]

        // Устанавливаем данные в элементы
        holder.courseName.text = currentItem.name
        holder.courseIntro.text = currentItem.intro

        // Для изображения можно использовать Glide/Picasso
        Glide.with(holder.itemView.context)
            .load(currentItem.coursePicture)
            .into(holder.courseImage)
    }

    override fun getItemCount() = courseList.size
}

