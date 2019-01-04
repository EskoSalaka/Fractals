# The fractals with feedback iteration

These images are results of just simple iteration or mandelbrot-style iteration

```scala 
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
```

# The images

For reference, the normal mandelbrot set with this iteration methods looks just like it should. Only, its obviously
not a great method for it.

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/mandelbrot.png" width="50%" height="50%"> 

---

Simple iteration of the exponential function exp(Z) - 1 for x=[-1,6] y=[-2,2]. The simpler function exp(Z) does
not seem to converge anywhere.

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/exponential1.png" width="50%" height="50%"> 

---

Mandelbrot iteration of the exponential function exp(Z) for x=[-0.1,0.1] y=[0.2,0.3]. Keping in mind the properties of 
the complex exp(Z), its not suprising to see a repeating pattern at intervals of Pi.

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/exponential_m3.png" width="50%" height="50%"> 

Lets take a closer look at x=[-0.1,0.1] y=[0.2,0.3]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/exponential_m1.png" width="50%" height="50%"> 

---

Simple and mandelbrot iteration of the inverse exponential function exp(-Z) for x=[-1,6] y=[-2,2]. 

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/exponential2.png" width="50%" height="50%"> 

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/exponential3.png" width="50%" height="50%"> 

---
