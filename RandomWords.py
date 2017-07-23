#Danielle Covarrubias
#Project 1

class Random:
	
	def __init__(self, seed):
		self.random1 = seed
	
	def next(self, range):
		self.random2 = ((7**5)*self.random1)%((2**31)-1)
		return self.random2 % range
	
	def choose(self, objects):
		self.length= len(objects)
		self.index = Random.next(self, self.length)
		return object[self.index]
	
class Nonce:
	def __init__(self, seed):
		self._first = []
		self._follow = {}
		self._random = Random.__init__(self, seed)
	
	def add(self, word):
		self._first.append(word[0])
		self._follow[self._first] = word[1]		
		return None
		
	def make(self, size):
		self.word = [size]
		self.word[0] = self._first[self._random]
		i=1
		while (i<=size):
			self.word[i] = self._follow[self._random]
			i=i+1
		
		return self.word
			
nw = Nonce(101)  
nw.add('ada')  
nw.add('algol')  
nw.add('bliss')  
nw.add('ceylon')  
nw.add('clojure')  
nw.add('curl')  
nw.add('dart')  
nw.add('eiffel')  
nw.add('elephant')  
nw.add('elisp')  
nw.add('falcon')  
nw.add('fortran')  
nw.add('go')  
nw.add('groovy')  
nw.add('haskell')  
nw.add('heron')  
nw.add('intercal')  
nw.add('java')  
nw.add('javascript')  
nw.add('latex')  
nw.add('lisp')  
nw.add('mathematica')  
nw.add('nice')  
nw.add('oak')  
nw.add('occam')  
nw.add('orson')  
nw.add('pascal')  
nw.add('postscript')  
nw.add('prolog')  
nw.add('python')  
nw.add('ruby')  
nw.add('scala')  
nw.add('scheme')  
nw.add('self')  
nw.add('snobol')  
nw.add('swift')  
nw.add('tex')  
nw.add('wolfram')
