package challenge

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers


class Test extends AnyFunSuite with Matchers {

  val testOneLine = "In 1991, while studying computer science at University of Helsinki, Linus Torvalds began a project that later became the Linux kernel. He wrote the program specifically for the hardware he was using and independent of an operating system because he wanted to use the functions of his new PC with an 80386 processor. Development was done on MINIX using the GNU C Compiler."
  //since it's a plugin for emails I assume that paragraph formatting should be preserved
  val testMultipleLines = "In 1991, while studying computer science at University of Helsinki, Linus Torvalds began a project that later became the Linux kernel.\nHe wrote the program specifically for the hardware he was using and independent of an operating system because he wanted to use the functions of his new PC with an 80386 processor. Development was done on MINIX using the GNU C Compiler."

  val exampleLength = 40
  val exampleResult = "In 1991, while studying computer science\nat University of Helsinki, Linus\nTorvalds began a project that later\nbecame the Linux kernel. He wrote the\nprogram specifically for the hardware he\nwas using and independent of an\noperating system because he wanted to\nuse the functions of his new PC with an\n80386 processor. Development was done on\nMINIX using the GNU C Compiler."
  val exampleResultMultiline = "In 1991, while studying computer science\nat University of Helsinki, Linus\nTorvalds began a project that later\nbecame the Linux kernel.\nHe wrote the program specifically for\nthe hardware he was using and\nindependent of an operating system\nbecause he wanted to use the functions\nof his new PC with an 80386 processor.\nDevelopment was done on MINIX using the\nGNU C Compiler."

  test("Example case") {
      Main.reformat(testOneLine, exampleLength) shouldBe exampleResult
  }

  test("Empty string should return empty string") {
    Main.reformat("", exampleLength) shouldBe empty
  }

  test("Text is shorter then line should return text") {
    Main.reformat(testOneLine, testOneLine.length) shouldBe testOneLine
  }

  test("Newlines should be preserved") {
    Main.reformat(testMultipleLines, 40) shouldBe  exampleResultMultiline
  }

  test("Text is already formatted should return identical formatted text") {
    Main.reformat(exampleResult, 40) shouldBe exampleResult
  }
}
