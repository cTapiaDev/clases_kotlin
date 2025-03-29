package cl.clases.wishlist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "wish-title") val title: String = "",
    @ColumnInfo(name = "wish-desc") val description: String = ""
)

object DummyWish {
    val washList = listOf(
        Wish(title = "Google Watch 2", description = "Un reloj de android"),
        Wish(title = "Oculus Quest 2", description = "Un set VR para jugar"),
        Wish(title = "Alas de Sangre", description = "Un libro best seller"),
        Wish(title = "Play Station 5", description = "Consola de videojuegos")
    )
}
