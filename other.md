# The fractals with other types of iteration iteration

These images are results of various other types of iteration processes. The one I currently have here is the 
"mandelpinski" type of iterations `Z -> f(Z)+C/Z^k`

```scala 
def iterate_mdp(c: Complex, f: Complex => Complex, maxIter: Int = 1000): Int = {
    var s: Complex = c

    for (n <- 0 until maxIter){
      s = f(s) + c/z
      if (s.re.isInfinity || s.imag.isInfinity) return n
    }

    0
  }
```

and iterations with a rising power such as `Zn+1 -> C*f(Zn)^n`

# The images

Mandelpinski iteration for `f(Z) = Z^2` for x=[-0.5,0] y=[-1,1]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/mandelpinski1.png" width="50%" height="50%"> 

It seems to have some intricate convergence areas that are not clearly visible with our level of detail. Lets take a 
closer look at x=[-0.1,0] y=[-0.1,0.1]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/mandelpinski2.png" width="50%" height="50%"> 

Lets xoom into the little mandelbrot at x=[-0.04,-0.029] y=[-0.057,-0.048]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/mandelpinski3.png" width="50%" height="50%"> 

The "center"  x=[-0.01,0] y=[-0.01,0.01]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/mandelpinski4.png" width="50%" height="50%"> 

---

The Mandelpinski version of the exponential function exp(z) for x=[-5,-5] y=[-10,-10]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/exp_mandelpinski1.png" width="50%" height="50%"> 

Zooming in at the spiral x=[-1.9,-1] y=[5,6]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/exp_mandelpinski2.png" width="50%" height="50%"> 

---

Rising power iteration `Zn+1 -> C*f(Zn)^n` of f(Z)=Z+1/Z for x=[-2,-2] y=[-2,-2]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/rising_pow1.png" width="50%" height="50%"> 

Zooming into x=[-0.5,-0.5] y=[-0.5,-0.5]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/rising_pow2.png" width="50%" height="50%"> 

---

Rising power iteration `Zn+1 -> Zn^n + C` for x=[-4,-1] y=[-2,-2]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/rising_pow3.png" width="50%" height="50%"> 

Zooming into x=[-0.8,-0.3] y=[-0.3,-0.3]

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/rising_pow4.png" width="50%" height="50%"> 

---

Rising power iteration `Zn+1 -> C*(1+1/Z)^n` for x=[-5,-5] y=[-5,-5] gives us quite a weird one, looks almost 
like a painting.

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/rising_power5.png" width="50%" height="50%"> 

Heres the same for `Zn+1 -> C*(1+1/Z^2)^n`

---

Rising power iteration `Zn+1 -> C*(1+1/exp(Z))^n` for x=[-5,-5] y=[-5,-5] 

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/rising_power6.png" width="50%" height="50%"> 

Zoomed into  x=[-1,-1] y=[-1,-1] 

<img src="https://raw.githubusercontent.com/EskoSalaka/Fractals/master/Images/rising_power7.png" width="50%" height="50%">