package fractals

import breeze.math._
import breeze.numerics.{exp, log}

import scala.collection.parallel.mutable.ParArray
import fractals.Util._

object Main extends App {

  var grid: Array[Array[Complex]] = _
  var imageArray: ParArray[Array[Int]] = _

  ////////////////////////////////// Simple and mandelbrot style iterations ////////////////////////////////////////////

//  grid = getGrid(2000, -2,1,-1,1)
//  imageArray = grid.par.map(_.map(iterate_m(_, (c: Complex) => c * c)))
//  createImage(imageArray, 1000, "mandelbrot")

//  grid = getGrid(1000, 1,2,-0.2,0.2)
//  imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => c.pow(c), 1000)))
//  createImage(imageArray, 1000, "power")

//  grid = getGrid(1000, -1,6,-2,2)
//  imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => exp(c) - 1)))
//  createImage(imageArray, 1000, "exponential1")

//  grid = getGrid(1000, -1,3,-11,11)
//  imageArray = grid.par.map(_.map(iterate_m(_, (c: Complex) => exp(c))))
//  createImage(imageArray, 1000, "exponential_m3")

//  grid = getGrid(2000, -0.1,0.1,0.2,0.3)
//  imageArray = grid.par.map(_.map(iterate_m(_, (c: Complex) => exp(c), 500)))
//  createImage(imageArray, 500, "exponential_m1")

//  grid = getGrid(1000, -10,10,-10,10)
//  imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => exp(-c))))
//  createImage(imageArray, 1000, "exponential2")

//  grid = getGrid(1000, -10,10,-10,10)
//  imageArray = grid.par.map(_.map(iterate_m(_, (c: Complex) => exp(-c))))
//  createImage(imageArray, 1000, "exponential3")

//  grid = getGrid(1000, -5,5,-5,5)
//  imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => exp(c))))
//  createImage(imageArray, 1000, "exponential")

//  grid = getGrid(1000, -5,5,-2,2)
//  imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => exp(c) - c)))
//  createImage(imageArray, 1000, "exponential4")

//  grid = getGrid(3000, 0.5,1.2,0.3,1.0)
//  imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => exp(c) - c, 500)))
//  createImage(imageArray, 500, "exponential5")

//  grid = getGrid(1000, -5,5,-1,1)
//  imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => c*c*exp(2*math.Pi*i*c))))
//  createImage(imageArray, 1000, "exponential6")

//  grid = getGrid(5000, -2,2,-1,2)
//  imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => exp(2*math.Pi*i*c))))
//  createImage(imageArray, 1000, "exponential7")

//  grid = getGrid(2000, -3,3,-1,1)
//  imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => exp(2*math.Pi*i*c)/(1-c))))
//  createImage(imageArray, 1000, "exponential8")

//  grid = getGrid(4000, 0.8,0.9,-0.05,0.05)
//  imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => exp(2*math.Pi*i*c)/(1-c))))
//  createImage(imageArray, 1000, "exponential9")

//  grid = getGrid(1000, -0.005,0.005,-0.005,0.005)
//  imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => exp(2*math.Pi*i*c)/(1-c))))
//  createImage(imageArray, 1000, "exponential10")

//  grid = getGrid(1000, -3,3,-1,1)
//  imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => exp(2*math.Pi*i*c*c)/(1-c*c))))
//  createImage(imageArray, 1000, "exponential11")

//  grid = getGrid(2000, -5,8,-5,5)
//  imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => c*c*exp(2*math.Pi*i*0.6151732)*(c-4)/(1-4*c))))
//  createImage(imageArray, 1000, "rational1")

//  grid = getGrid(5000, -1.5,2.6,-2,2)
//  imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => c*c*(c-1)/(1-i*c), 500)))
//  createImage(imageArray, 500, "rational2")

//  grid = getGrid(5000, -1,3,-2,2)
//  imageArray = grid.par.map(_.map(iterate_m(_, (c: Complex) => c*(1-c))))
//  createImage(imageArray, 1000, "rational3")

//  grid = getGrid(3000, -1,1.5,-1,1)
//  imageArray = grid.par.map(_.map(iterate_m(_, (c: Complex) => c*c*c - c - 1, 500)))
//  createImage(imageArray, 500, "rational_m4")

//  grid = getGrid(3000, -0.1,1.4,-0.5,0.5)
//  imageArray = grid.par.map(_.map(iterate_m(_, (c: Complex) => c*c*c - c - 1, 500)))
//  createImage(imageArray, 500, "rational_m5")

//  grid = getGrid(3000, 0.7,0.8,-0.31,-0.2)
//  imageArray = grid.par.map(_.map(iterate_m(_, (c: Complex) => c*c*c - c - 1, 500)))
//  createImage(imageArray, 500, "rational_m6")

//  grid = getGrid(3000, 0.774,0.78,-0.275,-0.265)
//  imageArray = grid.par.map(_.map(iterate_m(_, (c: Complex) => c*c*c - c - 1, 500)))
//  createImage(imageArray, 500, "rational_m7")

//  grid = getGrid(1000, -3,3,-3,3)
//  imageArray = grid.par.map(_.map(iterate_m(_, (c: Complex) => exp(c.re.abs + i*c.im.abs))))
//  createImage(imageArray, 1000, "exp_ship_m1")

//  grid = getGrid(3000, -5,5,-5,5)
//  imageArray = grid.par.map(_.map(iterate_m(_, (c: Complex) => exp(c)/2-exp(-c)/2, 500)))
//  createImage(imageArray, 500, "hyp_sin1")
//
//  grid = getGrid(1000, -5,5,-5,5)
//  imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => exp(c)/2-exp(-c)/2, 500)))
//  createImage(imageArray, 500, "hyp_sin2")

//  grid = getGrid(3000, -5,5,-5,5)
//  imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => exp(c)/2+exp(-c)/2, 500)))
//  createImage(imageArray, 500, "hyp_cos1")
//
//  grid = getGrid(1000, -5,5,-5,5)
//  imageArray = grid.par.map(_.map(iterate_m(_, (c: Complex) => exp(c)/2+exp(-c)/2, 500)))
//  createImage(imageArray, 500, "hyp_cos2")

//  grid = getGrid(1000, -5,5,-5,5)
//  imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => exp(c)-exp(-c), 500)))
//  createImage(imageArray, 500, "hyp_sin3")

//  grid = getGrid(1000, -5,5,-5,5)
//  imageArray = grid.par.map(_.map(iterate_m(_, (c: Complex) => exp(c)+exp(-c), 500)))
//  createImage(imageArray, 500, "hyp_cos3")

//  grid = getGrid(300, -5,5,-5,5)
//  for (x <- 0 until 90){
//    imageArray = grid.par.map(_.map(iterate_m(_, (c: Complex) => sinh(c)/(10-0.1 * x), 200)))
//    createImage(imageArray, 200, "zz_s" + x.toString)
//  }
//
//  for (x <- 0 until 90){
//    imageArray = grid.par.map(_.map(iterate_m(_, (c: Complex) => sinh(c)*(1+0.1 * x), 200)))
//    createImage(imageArray, 200, "zz_s" + (90+x).toString)
//  }

//  grid = getGrid(300, -5,5,-5,5)
//  for (x <- 0 until 90){
//    imageArray = grid.par.map(_.map(iterate_m(_, (c: Complex) => cosh(c)/(10-0.1 * x), 200)))
//    createImage(imageArray, 200, "zz_s" + x.toString)
//  }
//
//  for (x <- 0 until 90){
//    imageArray = grid.par.map(_.map(iterate_m(_, (c: Complex) => cosh(c)*(1+0.1 * x), 200)))
//    createImage(imageArray, 200, "zz_s" + (90+x).toString)
//  }

//  grid = getGrid(300, -5,5,-5,5)
//  for (x <- 0 until 90){
//    imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => cosh(c)/(10-0.1 * x), 200)))
//    createImage(imageArray, 200, "zz_s" + x.toString)
//  }
//
//  for (x <- 0 until 90){
//    imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => cosh(c)*(1+0.1 * x), 200)))
//    createImage(imageArray, 200, "zz_s" + (90+x).toString)
//  }

//  grid = getGrid(300, -5,5,-5,5)
//  for (x <- 0 until 90){
//    imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => sinh(c)/(10-0.1 * x), 200)))
//    createImage(imageArray, 200, "zz_s" + x.toString)
//  }
//
//  for (x <- 0 until 90){
//    imageArray = grid.par.map(_.map(iterate(_, (c: Complex) => sinh(c)*(1+0.1 * x), 200)))
//    createImage(imageArray, 200, "zz_s" + (90+x).toString)
//  }



  //////////////////////////////////////////// With Feedback ///////////////////////////////////////////////////////////

//  grid = getGrid(3000, -2,1,-1,1)
//  imageArray = grid.par.map(_.map(iterate_feedback_m(_, (c: Complex) => c * c)))
//  createImage(imageArray, 1000, "mandelbrot_feedback")

//  grid = getGrid(1000, -5,5,-5,5)
//  imageArray = grid.par.map(_.map(iterate_feedback(_, (c: Complex) => exp(c))))
//  createImage(imageArray, 1000, "exponential_feedback")

//  grid = getGrid(2000, -1,5,-5,5)
//  imageArray = grid.par.map(_.map(iterate_feedback_m(_, (c: Complex) => exp(c), 500)))
//  createImage(imageArray, 500, "exponential_feedback_m")

//  grid = getGrid(2000, 0,0.8,2.8,3.5)
//  imageArray = grid.par.map(_.map(iterate_feedback_m(_, (c: Complex) => exp(c), 1000)))
//  createImage(imageArray, 1000, "exponential_feedback_m2")

//  grid = getGrid(1000, -5,5,-7,7)
//  imageArray = grid.par.map(_.map(iterate_mdp(_, (c: Complex) => exp(c)-exp(-c), 500)))
//  createImage(imageArray, 500, "hyp_sin_feedback1")

//  grid = getGrid(5000, -2,1,-1,1)
//  imageArray = grid.par.map(_.map(iterate_mdp(_, (c: Complex) => exp(c)-exp(-c), 500)))
//  createImage(imageArray, 500, "hyp_sin_feedback2")

  /////////////////////////////////////// With Alternating functions ///////////////////////////////////////////////////

//  grid = getGrid(1000, 0,5,-10,10)
//  imageArray = grid.par.map(_.map(iterate_alt(_, (c: Complex) => exp(c), (c: Complex) => exp(-c))))
//  createImage(imageArray, 1000, "exponential_alt1")

//  grid = getGrid(1000, 0,5,1.5,4.8)
//  imageArray = grid.par.map(_.map(iterate_alt(_, (c: Complex) => exp(c), (c: Complex) => exp(-c))))
//  createImage(imageArray, 1000, "exponential_alt2")

//  grid = getGrid(1000, 0,5,-10,10)
//  imageArray = grid.par.map(_.map(iterate_alt_m(_, (c: Complex) => exp(c), (c: Complex) => exp(-c))))
//  createImage(imageArray, 1000, "exponential_alt_m1")

//  grid = getGrid(1000, 0,5,1.5,4.8)
//  imageArray = grid.par.map(_.map(iterate_alt_m(_, (c: Complex) => exp(c), (c: Complex) => exp(-c))))
//  createImage(imageArray, 1000, "exponential_alt_m2")

//  grid = getGrid(5000, -1.6,.8,-1.4,1.4)
//  imageArray = grid.par.map(_.map(iterate_alt_m(_, (c: Complex) => c*c, (c: Complex) => i*c*c, 500)))
//  createImage(imageArray, 500, "rational_alt1")

//  grid = getGrid(2000, -1.1,1.1,-1.0,1.8)
//  imageArray = grid.par.map(_.map(iterate_alt_m(_, (c: Complex) => i*c*c, (c: Complex) => c*c, 500)))
//  createImage(imageArray, 500, "rational_alt_m5")

//  grid = getGrid(5000, 0.28,.43,0.7,.85)
//  imageArray = grid.par.map(_.map(iterate_alt_m(_, (c: Complex) => c*c, (c: Complex) => i*c*c, 1000)))
//  createImage(imageArray, 1000, "rational_alt2")

//  grid = getGrid(1000, -2,2,-0.7,0.7)
//  imageArray = grid.par.map(_.map(iterate_alt_m(_, (c: Complex) => c*c, (c: Complex) => c*(1-c), 500)))
//  createImage(imageArray, 500, "rational_alt3")

//  grid = getGrid(1000, -5,5,-10,10)
//  imageArray = grid.par.map(_.map(iterate_alt_m(_, (c: Complex) => exp(c), (c: Complex) => c*c, 2000)))
//  createImage(imageArray, 2000, "exponential_alt_m3")

//  grid = getGrid(2500, -2,1,-1,1)
//  imageArray = grid.par.map(_.map(iterate_alt_m(_, (c: Complex) => c*c, (c: Complex) => c*c*c, 500)))
//  createImage(imageArray, 500, "rational_alt_m4")

//  grid = getGrid(1000, -5,5,-5,5)
//  imageArray = grid.par.map(_.map(iterate_alt_m(_, (c: Complex) => exp(c)-exp(-c), (c: Complex) => exp(c)+exp(-c), 500)))
//  createImage(imageArray, 500, "hyp_sin_alt1")

//  grid = getGrid(2000, -0.012,0.014,1.565,1.58)
//  imageArray = grid.par.map(_.map(iterate_alt_m(_, (c: Complex) => exp(c)-exp(-c), (c: Complex) => exp(c)+exp(-c), 500)))
//  createImage(imageArray, 500, "hyp_sin_alt2")

//  grid = getGrid(1000, -3,2,-10,10)
//  imageArray = grid.par.map(_.map(iterate_m(_, (c: Complex) => (exp(math.Pi*c)-exp(-math.Pi*c))/(2*math.Pi*c),500)))
//  createImage(imageArray, 500, "sss")

  /////////////////////////////////////// The other stuff //////////////////////////////////////////////////////////////

//  grid = getGrid(1000, -0.5,0,-0.5,0.5)
//  imageArray = grid.par.map(_.map(iterate_mdp(_, (c: Complex) => c*c, 1000)))
//  createImage(imageArray, 1000, "mandelpinski1")

//  grid = getGrid(3000, -0.1,0,-0.1,0.1)
//  imageArray = grid.par.map(_.map(iterate_mdp(_, (c: Complex) => c*c, 2000)))
//  createImage(imageArray, 2000, "mandelpinski2")

//  grid = getGrid(5000, -0.04,-0.029,-0.057,-0.048)
//  imageArray = grid.par.map(_.map(iterate_mdp(_, (c: Complex) => c*c, 1000)))
//  createImage(imageArray, 1000, "mandelpinski3")

//  grid = getGrid(5000, -0.01,0,-0.01,0.01)
//  imageArray = grid.par.map(_.map(iterate_mdp(_, (c: Complex) => c*c, 1000)))
//  createImage(imageArray, 1000, "mandelpinski4")

//  grid = getGrid(3000, -5,5,-10,10)
//  imageArray = grid.par.map(_.map(iterate_mdp(_, c => exp(c), 500)))
//  createImage(imageArray, 500, "exp_mandelpinski1")

//  grid = getGrid(3000, -1.9,-1,5,6)
//  imageArray = grid.par.map(_.map(iterate_mdp(_, c => exp(c), 500)))
//  createImage(imageArray, 500, "exp_mandelpinski2")

//  grid = getGrid(1000, -5,5,-10,10)
//  imageArray = grid.par.map(_.map(iterate_mdp(_, c => c.pow(log(c)), 500)))
//  createImage(imageArray, 500, "log_mandelpinski1")

//  grid = getGrid(1000, -5,5,-10,10)
//  imageArray = grid.par.map(_.map(iterate_mdp(_, c => sinh(c), 500)))
//  createImage(imageArray, 500, "sinh_mandelpinski1")
//
//  grid = getGrid(1000, -5,5,-10,10)
//  imageArray = grid.par.map(_.map(iterate_mdp(_, c => cosh(c), 500)))
//  createImage(imageArray, 500, "cosh_mandelpinski1")







}