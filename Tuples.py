
# Charlie Green & Danielle Covarrubias
# Lab 1
# 9/14/16

import types

def left(e):
 return e[0]
def op(e):
 return e[1]
def right(e):
 return e[2]

def isInside(v, e):
 if v == e:
  return True
 elif type(e) == types.TupleType:
  L = left(e)
  O = op(e)
  R =right(e)
  if v == R:
   return True
  elif v == L:
   return True
  elif type(R) == types.TupleType:
   return isInside(v, R)
  elif type(L) == types.TupleType:
   return isInside(v, L)
  else:
   return False
 else:
  return False

def solve(v, q):
 if isInside(v,left(q)):
  return solving(v, q)
 elif isInside(v, right(q)):
  temp = (right(q), op(q), left(q))
  return solving(v, temp)
 else:
  return None

def solving(v, q):
 if v == left(q):
  return q
 elif op(left(q)) == '+':
  return solvingAdd(v,q)
 elif op(left(q)) == '-':
  return solvingSubtract(v,q)
 elif op(left(q)) == '*':
  return solvingMultiply(v,q)
 elif op(left(q)) == '/':
  return solvingDivide(v,q)
    
def solvingAdd(v, q):
 if isInside(v, left(left(q))):
  temp = (left(left(q)), '=', (right(q), '-', right(left(q))))     
  return solving(v, temp)                            
 elif isInside(v, right(left(q))):               
  temp = (right(left(q)), '=', (right(q), '-', left(left(q))))    
  return solving(v, temp)                            
  
def solvingSubtract(v, q):
 if isInside(v, left(left(q))):
  temp = (left(left(q)), '=', (right(q), '+', right(left(q))))
  return solving(v, temp)
 elif isInside(v, right(left(q))):
  temp = (right(left(q)), '=', (left(left(q)), '-', right(q)))
  return solving(v, temp)

def solvingMultiply(v, q):
 if isInside(v, left(left(q))):
  temp = (left(left(q)), '=', (right(q), '/', right(left(q))))
  return solving(v, temp)
 elif isInside(v, right(left(q))):
  temp = (right(left(q)), '=', (right(q), '/', left(left(q))))
  return solving(v, temp)

def solvingDivide(v, q):
 if isInside(v, left(left(q))):
  temp = (left(left(q)), '=', (right(q), '*', right(left(q))))
  return solving(v, temp)
 elif isInside(v, right(left(q))):
  temp = (right(left(q)), '=', (left(left(q)), '/', right(q)))
  return solving(v, temp)
 


print(isInside('x', 'x'))                          #  True
print(isInside('x', 'y'))                          #  False
print(isInside('x', ('x', '+', 'y')))              #  True
print(isInside('x', ('a', '+', 'b')))              #  False
v ='x'
e = (('m', '*', 'x'), '+', 'b')
print(isInside(v, e))  #  True

print(solve('x', (('a', '+', 'x'), '=', 'c')))  #  ('x', '=', ('c', '-', 'a'))
print(solve('x', (('x', '+', 'b'), '=', 'c')))  #  ('x', '=', ('c', '-', 'b'))

print(solve('x', (('a', '-', 'x'), '=', 'c')))  #  ('x', '=', ('a', '-', 'c'))
print(solve('x', (('x', '-', 'b'), '=', 'c')))  #  ('x', '=', ('c', '+', 'b'))

print(solve('x', (('a', '*', 'x'), '=', 'c')))  #  ('x', '=', ('c', '/', 'a'))
print(solve('x', (('x', '*', 'b'), '=', 'c')))  #  ('x', '=', ('c', '/', 'b'))

print(solve('x', (('a', '/', 'x'), '=', 'c')))  #  ('x', '=', ('a', '/', 'c'))
print(solve('x', (('x', '/', 'b'), '=', 'c')))  #  ('x', '=', ('c', '*', 'b'))

print(solve('x', ('y', '=', (('m', '*', 'x'), '+', 'b'))))
# ('x', '=', (('y', '-', 'b'), '/', 'm')

# My Tests and results

print(isInside('x', ('a', '+', 'x')))              #  True
print(solve('x', (('m', '*', 'x'), '=', ('b', '+', 'y')))) # ('x', '=', (('b', '+', 'y'), '/', 'm')
print(solve('x', ('y', '=', ('b', '+', ('m', '*', 'x'))))) # ('x', '=', (('y', '-', 'b'), '/', 'm')
