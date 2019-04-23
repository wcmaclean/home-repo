# -*- coding: utf-8 -*-
"""
Created on Sat Sep 29 07:32:25 2018

@author: wmaclean
"""

import numpy as np
import pandas as pd

import sklearn
from sklearn.neighbors import NearestNeighbors

# load batting data
batting = pd.read_csv('mlb2014-batting.csv')
batting.columns = ['playerID', 'nameFirst', 'nameLast', 
                   'bats', 'throws', 'age', 'year', 
                   'stints', 'teamID', 'lg', 'G', 'tap', 
                   'AB', 'R', 'H', 'db', 'tr', 'HR', 
                   'RBI', 'SB', 'CS', 'BB', 'SO', 'IBB', 
                   'hbp', 'SH', 'SF', 'GIDP', 'avg', 'obp', 
                   'slg', 'woba', 'PRO', 'GURU', 'ROTO', 
                   'pos1', 'g1', 'pos2', 'g2', 'pos3', 
                   'g3', 'pos4', 'g4', 'pos5', 'g5', 
                   'baseball_prospectus_id', 'mlbam_id', 
                   'n2013']
print(batting.head())

# these are the hitting stats you want
#   [AB, AVG, HR]
t = [400, 300, 25]

# matrix of values for those features
X = batting.ix[:,(13, 25, 18)].values
print(X[0:5])

# find the nearest neighbors for the whole set
print('Neighbors')
nbrs = NearestNeighbors(n_neighbors=5).fit(X)
distances, indices = nbrs.kneighbors([t])

# get just the indices of the nearest neighbors
print(indices)

# see what the recommendations are
print("Recommendations")
for i in indices:
    print(batting.iloc[i])

#for i in nbrs.kneighbors([t]):
#    for j in i:
#        print(j)

