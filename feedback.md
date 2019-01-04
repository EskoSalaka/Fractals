# The fractals with feedback iteration

The idea of the feedback is to remember the result of the previous iteration and use it in the next one in some way. A
simple way is to just add it as follows

```scala 
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
```

We can also do the same in a similar way for the mandelbrot-style iteration

```scala 
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
```

# The images

The normal mandelbrot set `Zn -> Zn^2 + Zn-1 + C` x=[-2,1] y=[-1,1]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/mandelbrot_feedback.png" width="50%" height="50%"> 

---

Simple iteration of the exponential function `Zn -> exp(Zn) + Zn-1` x=[-5,5] y=[-5,5]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/exponential_feedback.png" width="50%" height="50%"> 

---

Mandelbrot-style iteration of the exponential function `Zn -> exp(Zn) + Zn-1 + C` x=[-1,5] y=[-5,5]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/exponential_feedback_m.png" width="50%" height="50%"> 

This one is a bit more interesting. We can see little Mandelbrots partly covered by the tendrils from
the exponential functions. Lets zoom in on one of those around x=[0,0.8] y=[2.8,3.5]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/exponential_feedback_m2.png" width="50%" height="50%"> 

---

Hyperbolic sine exp(Z) - exp(-Z) with feedback for x=[-5,5] y=[-5,5] and x=[-1,2] y=[-2,2]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/hyp_sin_feedback1.png" width="50%" height="50%"> 

Again we see some hidden mandelbrots. Lets zoom in the middle to x=[-1,2] y=[-1,1]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/hyp_sin_feedback2.png.png" width="50%" height="50%"> 

