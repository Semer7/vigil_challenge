package challenge

import scala.annotation.tailrec

object Main extends App {

  def reformat(text: String, lineLength: Int): String = {
    if (text.length < lineLength) text
    else {
      val words = text.split(" ")

      rearrange(words, lineLength)
    }
  }

  @tailrec
  private def rearrange(
      words: Iterable[String],
      lineLength: Int,
      acc: String = "",
      currentLineLength: Int = 0
  ): String = {
    if (words.isEmpty) acc
    else {
      val word = words.head
      val wordLength = word.length
      val newLineIndex = word.indexOf('\n')

      if (newLineIndex >= 0) {
        rearrange(
          words.tail,
          lineLength,
          acc.appendedAll(s" $word"),
          wordLength - newLineIndex
        )
      } else if (currentLineLength + wordLength + 1 > lineLength) {
        rearrange(
          words.tail,
          lineLength,
          acc.appendedAll(s"\n$word"),
          wordLength
        )
      } else {
        val newWord = if (currentLineLength == 0) word else s" $word"

        rearrange(
          words.tail,
          lineLength,
          acc.appendedAll(newWord),
          currentLineLength + newWord.length
        )
      }
    }
  }
}
