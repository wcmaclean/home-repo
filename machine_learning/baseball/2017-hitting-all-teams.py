# -*- coding: utf-8 -*-
"""
Created on Mon Sep 24 12:36:56 2018

@author: wmaclean
"""

# load the housing data set
import pandas as pd
df = pd.read_csv('2017-hitting-all-teams.csv')
df.columns = ['Tm', '#Bat', 'BatAge', 'R/G',
              'G', 'PA', 'AB', 'R', 'H',
              '2B', '3B', 'HR', 'RBI', 'SB',
              'CS', 'BB', 'SO', 'BA', 'OBP', 
              'SLG', 'OPS', 'OPS+', 'TB', 
              'GDP', 'HBP', 'SH', 'SF', 'IBB', 'LOB' ]
print(df.head())

# visualizing important characteristics
# looking for a linear relationship
import matplotlib.pyplot as plt
import seaborn as sns
sns.set(style='whitegrid', context='notebook')
cols = ['BatAge', 'R/G', 'BA', 'OBP', 
        'SLG', 'OPS', 'OPS+' ]
sns.pairplot(df[cols], size=2.5);
plt.show()

# correlation matrix = a matrix with the Pearson product-moment correlation coefficients
# looking for a correlation close to 1 on a scale of 0 to 1
import numpy as np
cm = np.corrcoef(df[cols].values.T)
sns.set(font_scale=1.5)
hm = sns.heatmap(cm,
                 cbar=True,
                 annot=True,
                 square=True,
                 fmt='.2f',
                 annot_kws={'size': 15},
                 yticklabels=cols,
                 xticklabels=cols)
plt.show()


# implementing an ordinary least squares linear regression model

class LinearRegressionGD(object):
    
    def __init__(self, eta=0.01, n_iter=10):
        self.eta = eta
        self.n_iter=n_iter
    
    def fit(self, X, y):
        self.w_= np.zeros(1 + X.shape[1])
        self.cost_ = []
        
        for i in range(self.n_iter):
            output = self.net_input(X)
            errors = (y - output)
            self.w_[1:] += self.eta * X.T.dot(errors)
            self.w_[0] += self.eta * errors.sum()
            cost = (errors**2).sum()/ 2.0
            self.cost_.append(cost)
        return self
    
    def net_input(self, X):
        return np.dot(X, self.w_[1:]) + self.w_[0]
    
    def predict(self, X):
        return self.net_input(X)
    
# let's look at the Linear Regression
# using RM and MEDV, because they have a strong linear relationship
X = df[['BA']].values
y = df['OPS'].values
#y = pd.factorize(df['MEDV'].values)[0].reshape(-1, 1)
from sklearn.preprocessing import StandardScaler
import matplotlib.pyplot as plt
sc_x = StandardScaler()
sc_y = StandardScaler()
X_std = sc_x.fit_transform(X)
y_std = sc_y.fit_transform(y[:, np.newaxis]).flatten() # reshape to 2D array 
lr = LinearRegressionGD()
lr.fit(X_std, y_std)
plt.plot(range(1, lr.n_iter+1), lr.cost_)
plt.ylabel('SSE')
plt.xlabel('Epoch')
plt.show()


# for plotting
def lin_regplot(X, y, model):
    plt.scatter(X, y, c='blue')
    plt.plot(X, model.predict(X), color='red')
    return None

# plot
lin_regplot(X_std, y_std, lr)
plt.xlabel("BA")
plt.ylabel("OPS")
plt.show()


# estimating the coefficient of a regression model
from sklearn.linear_model import LinearRegression
slr = LinearRegression()
slr.fit(X, y)
print("Slope: %.3f" % slr.coef_[0])
print("Intercept: %.3f" % slr.intercept_)

lr = LinearRegression()

# fit a simple linear regression model for comparison
lr.fit(X, y)
X_fit = np.arange(250, 600, 10)[:, np.newaxis]
X_lin_fit = lr.predict(X_fit)

# fit a polynomial regression model on the transformed featres for polynomial regression
pr.fit(X_quad, y)
y_quad_fit = pr.predict(quadratic.fit_transform(X_fit))

#plot the results
plt.scatter(X2, y2, label='training points')
plt.plot(X2_fit, y2_lin_fit,
         label='linear fit', linestyle='--')
plt.plot(X2_fit, y2_quad_fit,
         label='quadratic fit')
plt.legend(loc='upper left')
plt.show()

y2_lin_pred = lr.predict(X2)
y2_quad_pred = pr.predict(X2_quad)
print('Training MSE linear: %3f, quadratic: %.3f' % (
        mean_squared_error(y2, y2_lin_pred),
        mean_squared_error(y2, y2_quad_pred)))
print('Training R^2 linear: %.3f, quadratic: %.3f' % (
      r2_score(y2, y2_lin_pred),
      r2_score(y2, y2_quad_pred)))


