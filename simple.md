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

Mandelbrot iteration of the exponential function exp(Z) for x=[-1,3] y=[0.2,-11,11]. Keping in mind the properties of 
the complex exp(Z), its not suprising to see a repeating pattern at intervals of Pi.

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/exponential_m3.png" width="50%" height="50%"> 

Lets take a closer look at x=[-0.1,0.1] y=[0.2,0.3]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/exponential_m1.png" width="50%" height="50%"> 

---

Simple and mandelbrot iteration of the inverse exponential function exp(-Z) for x=[-10,10] y=[-10,10]. 

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/exponential2.png" width="50%" height="50%"> 

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/exponential3.png" width="50%" height="50%"> 

---

A bit more complex simple iteration of Z^2*exp(2*Pi*i*Z) for x=[-5,5] y=[-1,1]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/exponential6.png" width="50%" height="50%"> 

---

Simple iteration of exp(2*Pi*i*Z^2)/(1-Z^2) for x=[-3,3] y=[-1,1]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/exponential11.png" width="50%" height="50%"> 

---

Mandelbrot iteration of Z^3-Z-1 for x=[-0.1,1.4] y=[-0.5,0.5]. We get some interesting tendrils leading to the point 0.

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/rational_m5.png" width="50%" height="50%"> 

Lets take a closer look at the starting point of the tendril x=[0.7,0.8] y=[-0.31,-0.2]. There are some intricate
patterns that emerge

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/rational_m6.png" width="50%" height="50%"> 

And a closer look at a spiral x=[0.774,0.78] y=[-0.275,-0.265]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/rational_m7.png" width="50%" height="50%"> 
