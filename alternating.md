# The fractals with alternating functions

The idea of this method is to use multiple different functions for the iteration in some manner. For example, A simple 
way to do this is just to alternate between two functions f1 and f2 every other iteration

```scala 
def iterate_alt(c: Complex, f1: Complex => Complex, f2: Complex => Complex, maxIter: Int = 1000): Int = {
    var s: Complex = c
    
    for (n <- 0 until maxIter){
      if (n % 2 == 0) s = f1(s)
      else s = f2(s)
    
      if (s.re.isInfinity || s.imag.isInfinity) return n
    }
    
    0
}
```

We can also do the same in a similar way for the mandelbrot-style iteration

```scala 
def iterate_alt_m(c: Complex, f1: Complex => Complex, f2: Complex => Complex, maxIter: Int = 1000): Int = {
    var s: Complex = c
    
    for (n <- 0 until maxIter){
      if (n % 2 == 0) s = f1(s) + c
      else s = f2(s) + c
    
      if (s.re.isInfinity || s.imag.isInfinity) return n
    }
    
    0
}
```

After doing a bit of testing with this method, it seems that the order of applying the functions has a big effect.
Flipping the order of the functions can make the fractal look drastically different or in some cases it can add "more"
different kinds of details in the original one.

# The images

Mandelbrot style iteration between functions Z^2 and i*Z^2 for x=[-1.6,0.8] y=[-1.4,1.4]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/rational_alt1.png" width="50%" height="50%"> 

We get an interesting looking "twisted" Mandelbrot set. Basically, doing the normal mandelbrot iteration for i*Z^2 just
flips the set 90 degrees clockwise and this doing the alternating version partly "twists" it to a mix between the two.
Its kind of suprising that the image looks quite coherent and not choppy like some non-well-behaving functions. Lets
take a closer look at the top right of the image x=[0.28,0.43] y=[0.7,0.85]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/rational_alt2.png" width="50%" height="50%"> 

To demnostrate how switching the order affects the result, lets look at the same for i*Z^2 and Z^2 for 
x=[-1.1,1.1] y=[-1.0,1.8]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/rational_alt_m5.png" width="50%" height="50%"> 

---

Mandelbrot style iteration between functions Z^2 and Z(1-Z) for x=[-2,2] y=[-0.7,0.7]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/rational_alt3.png" width="50%" height="50%"> 

---

Normal iteration between the functions exp(Z) and exp(-Z) for x=[0,5] y=[-10,10]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/exponential_alt1.png" width="50%" height="50%"> 


---

Mandelbrot style iteration between the functions exp(Z) and exp(-Z) for x=[0,5] y=[-10,10]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/exponential_alt_m1.png" width="50%" height="50%"> 

---

Mandelbrot style iteration between the functions exp(Z) and Z^2 for x=[-5,5] y=[-10,10]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/exponential_alt_m3.png" width="50%" height="50%">

---

Mandelbrot style iteration between the functions Z^2 and Z^3 for x=[-2,1] y=[-1,1]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/rational_alt_m4.png" width="50%" height="50%"> 

---

Alternating between hyperbolic sine exp(Z) - exp(-Z) and cosine exp(Z) + exp(-Z) x=[-5,5] y=[-5,5] with mandelbrot style 
iteration

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/hyp_sin_alt1.png" width="50%" height="50%"> 

There are some this areas of convergence including a copy of a mandelbrot set at x=[-0.012,0.014] y=[1.565,1.58]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/hyp_sin_alt2.png" width="50%" height="50%"> 

The following gifs demonstrate the behaviour of sinh and cosh by a constant from 10->1 and 1->1/10 with simple 
and mandelbrot iterations.

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/sinh_cosh_alt_scaling.gif"> 

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/sinh_cosh_alt_m_scaling.gif"> 

