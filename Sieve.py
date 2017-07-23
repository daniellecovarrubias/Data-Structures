#Danielle Covarrubias & Charlie Green
#Lab 3

class Sieve:
	def __init__(self, max):
		if max < 0:
			raise RuntimeError
		else:
			
			self.numbers = [True]*max
			
			self.numbers[0] = False
			self.numbers[1] = False

		
	def findPrimes(self):
		i = 0
		for index in self.numbers:
			if index:
				index2 = i
				while index2 < len(self.numbers)-1:
						index2 = index2 + i
						if index2 > len(self.numbers)-1:
							break
						self.numbers[index2] = False
						
			i +=1		
					
	def howMany(self):
		print(reduce((lambda a,b: a+b), self.numbers))
	
	def toList(self):
		index=0
		self.empty = []
		while index < len(self.numbers)-1:
			if self.numbers[index]:
				self.empty.append(index)
			index += 1	
				
		return self.empty


s = Sieve(100)
s.howMany() #98
s.findPrimes()
s.howMany() #25
print(s.toList()) #[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]

s = Sieve(50)
s.howMany() #48
s.findPrimes()
s.howMany() #15
print(s.toList()) #[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]

s = Sieve(250)
s.howMany() #248
s.findPrimes()
s.howMany() #53
print(s.toList()) #[2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163 ,167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241]


