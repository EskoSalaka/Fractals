package fractals

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File

import breeze.math._
import breeze.linalg.{DenseVector, linspace}
import breeze.math.Complex
import breeze.numerics.{exp, log}
import javax.imageio.ImageIO

import scala.collection.parallel.mutable.ParArray

object Util {

  def getColor(iter: Int, maxIter: Int):Color ={

    val c = 3 * log(iter) / log(maxIter - 1.0)

    if ( c < 1) new Color((255 * c).toInt, 0, 0)
    else if (c < 2) new Color(255, (255*(c - 1)).toInt, 0)
    else new Color(255, 255, (255*(c - 2)).toInt)
  }

  def createImage(pixelArray: ParArray[Array[Int]], maxIter: Int, imageName: String): Unit ={
    val h = pixelArray.length
    val w = pixelArray.head.length
    val out = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB)

    for (y <- 0 until h; x <- 0 until w){
      if (pixelArray(y)(x) == 0){
        out.setRGB(x, y, 0)
      } else {
        out.setRGB(x, y, getColor(pixelArray(y)(x), maxIter).getRGB)
      }

    }

    ImageIO.write(out, "png", new File("Images\\" + imageName + ".png"))
  }

  def getGrid(baseAccuracy: Int ,
              xmin: Double,  xmax: Double,
              ymin: Double,  ymax: Double): Array[Array[Complex]] = {

    var nx: Int = 0
    var ny: Int = 0

    if ((xmax - xmin).abs > (ymax - ymin).abs) {
      ny = baseAccuracy
      nx = (baseAccuracy * (xmax - xmin).abs / (ymax - ymin).abs).toInt
    } else {
      nx = baseAccuracy
      ny = (baseAccuracy * (ymax - ymin).abs / (xmax - xmin).abs).toInt
    }

    val grid: Array[Array[Complex]] = Array.ofDim[Complex](ny, nx)
    val xspace: DenseVector[Double] = linspace(xmin, xmax, nx)
    val yspace: DenseVector[Double] = linspace(ymax, ymin, ny)

    for (y <- 0 until ny; x <- 0 until nx){
      grid(y)(x) = Complex(xspace(x), yspace(y))
    }

    grid
  }

  def sinh(c: Complex): Complex = {
    (exp(c) - exp(-c))/2
  }

  def cosh(c: Complex): Complex = {
    (exp(c) + exp(-c))/2
  }

  def iterate(c: Complex, f: Complex => Complex, maxIter: Int = 1000): Int = {
    var s: Complex = c

    for (n <- 0 until maxIter){
      s = f(s)
      if (s.re.isInfinity || s.imag.isInfinity) return n
    }

    0
  }

  def iterate_m(c: Complex, f: Complex => Complex, maxIter: Int = 1000): Int = {
    var s: Complex = c

    for (n <- 0 until maxIter){
      s = f(s) + c
      if (s.re.isInfinity || s.imag.isInfinity) return n
    }

    0
  }

  def iterate_mdp(c: Complex, f: Complex => Complex, maxIter: Int = 1000): Int = {
    var s: Complex = c

    for (n <- 0 until maxIter){
      s = f(s) + c/s
      if (s.re.isInfinity || s.imag.isInfinity) return n
    }

    0
  }

  def iterate_feedback(c: Complex, f: Complex => Complex, maxIter: Int = 1000): Int = {
    var s: Complex = c
    var feedback: Complex = 0*i

    for (n <- 0 until maxIter){
      s = f(s) + feedback
      feedback = s

      if (s.re.isInfinity || s.imag.isInfinity) return n
    }

    0
  }

  def iterate_feedback_full(c: Complex, f: Complex => Complex, maxIter: Int = 1000): Int = {
    var s: Complex = c
    var feedback: Complex = 0*i

    for (n <- 0 until maxIter){
      s = f(s) + feedback
      feedback += s

      if (s.re.isInfinity || s.imag.isInfinity) return n
    }

    0
  }

  def iterate_feedback_m(c: Complex, f: Complex => Complex, maxIter: Int = 1000): Int = {
    var s: Complex = c
    var feedback: Complex = 0*i

    for (n <- 0 until maxIter){
      s = f(s) + c + feedback
      feedback = s

      if (s.re.isInfinity || s.imag.isInfinity) return n
    }

    0
  }

  def iterate_feedback_full_m(c: Complex, f: Complex => Complex, maxIter: Int = 1000): Int = {
    var s: Complex = c
    var feedback: Complex = 0*i

    for (n <- 0 until maxIter){
      s = f(s) + c + feedback
      feedback += s

      if (s.re.isInfinity || s.imag.isInfinity) return n
    }

    0
  }

  def iterate_alt(c: Complex, f1: Complex => Complex, f2: Complex => Complex, maxIter: Int = 1000): Int = {
    var s: Complex = c

    for (n <- 0 until maxIter){
      if (n % 2 == 0) s = f1(s)
      else s = f2(s)

      if (s.re.isInfinity || s.imag.isInfinity) return n
    }

    0
  }

  def iterate_alt_m(c: Complex, f1: Complex => Complex, f2: Complex => Complex, maxIter: Int = 1000): Int = {
    var s: Complex = c

    for (n <- 0 until maxIter){
      if (n % 2 == 0) s = f1(s) + c
      else s = f2(s) + c

      if (s.re.isInfinity || s.imag.isInfinity) return n
    }

    0
  }

  def iterate_rising_pow1(c: Complex, f: Complex => Complex, maxIter: Int = 1000): Int = {
    var s: Complex = c

    for (n <- 0 until maxIter){
      s = c*f(s).pow(n)

      if (s.re.isInfinity || s.imag.isInfinity) return n
    }

    0
  }

  def iterate_rising_pow2(c: Complex, f: Complex => Complex, maxIter: Int = 1000): Int = {
    var s: Complex = c

    for (n <- 0 until maxIter){
      s = f(s).pow(n) + c

      if (s.re.isInfinity || s.imag.isInfinity) return n
    }

    0
  }
}
