# Automated Investment Strategies with Machine Learning
[![scikit-learn](https://img.shields.io/badge/scikit--learn-%23F7931E.svg?style=flat&logo=scikit-learn&logoColor=white)](https://img.shields.io/badge/scikitlearn-F7931E.svg?style=for-the-badge&logo=scikit-learn&logoColor=white) [![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

## Over view

This project aims to develop a comprehensive framework for creating and enhancing automated investment strategies utilizing Machine Learning (ML) techniques. The focus is on the Brazilian stock market, with specific emphasis on the Localiza (RENT3) stock. The project incorporates supervised learning, ensemble methods, and stacking to build and refine models for decision-making in stock trading. The code and reports (in portuguese) are organized for easy understanding and replication.

## Project Structure

#### Part 1: Supervised Learning Framework

In this section, we lay the foundation for the project by implementing a supervised learning framework. Key steps include:

1. **Problem Definition**: Understanding the challenges of algorithmic trading and proposing a solution using Machine Learning.
   
2. **Solution Definition**: Creating a series of experiments involving the following stages:

   - **Step 1**: Building a dataset for supervised learning.
   - **Step 2**: Developing and analyzing supervised ML models.
   - **Step 3**: Creating automated investment strategies using ML and analyzing returns.

3. **Requirements and Results Analysis**: Implementing the following requirements for each stage:

   - **Step 1**: Constructing a feature-rich dataset for ML models, including daily stock prices, technical indicators, statistical data, and lag features.
   
   - **Step 2**: Implementing Random Forest for classification and Multilayer Perceptron for regression. Employing various validation techniques and calculating metrics such as AUC, Precision, Recall, MAE, and RMSE.
   
   - **Step 3**: Simulating returns using the ML model outputs, calculating daily returns, and generating key financial metrics.

4. **Return Simulator**: Simulating returns using the model outputs.

5. **Report**: Providing a detailed report covering utilized languages, packages, baseline analysis, ML results, and financial analysis.

#### Part 2: Ensemble and Stacking Techniques

The second part of the project focuses on enhancing investment strategies through ensemble and stacking methods. This involves:

1. **Problem Definition**: Extending the project to include ensemble learning and stacking techniques for improved decision-making.

2. **Solution Definition**: Conducting experiments with ensemble learning and stacking for both regression and classification, utilizing models likeRandom Forest, Multilayer Perceptron, XGBoost, Naive Bayes, and k-Nearest Neighbors: 

   - **Ensemble Learning**: Combining ML model outputs for regression and classification using techniques such as simple averaging and weighted averaging based on model accuracy.
   
   - **Stacking**: Employing a non-linear stacking model (Multilayer Perceptron) to aggregate outputs from individual models.

3. **Requirements and Results Analysis**: Developing models for regression and classification, applying ensemble learning and stacking techniques, and calculating metrics such as AUC, Precision, Recall, MAE, and RMSE. Comparing against baseline models.

4. **Return Simulator**: Simulating returns using the ensemble and stacking models.

5. **Report**: Providing a comprehensive report covering languages, packages, baseline analysis, ML results, and financial analysis.

#### Part 3: Validation and Continuous Improvement

In the final part, the project extends its capabilities by introducing validation with sliding windows and continued model refinement. Key aspects include:

1. **Problem Definition**: Enhancing the framework by introducing validation with sliding windows for continuous improvement.

2. **Solution Definition**: Conducting experiments involving:

   - **Model Validation with Sliding Windows**: Retraining models at daily, weekly, and monthly intervals for continuous improvement.
   
   - **Ensemble and Stacking Refinement**: Further refining ensemble and stacking models.

3. **Requirements and Results Analysis**: Adapting models for validation with sliding windows, refining ensemble and stacking models, and calculating metrics as per previous sections.

4. **Return Simulator**: Simulating returns using the refined models.

5. **Report**: Providing a comprehensive report covering languages, packages, baseline analysis, ML results, and financial analysis.

## Dataset

The project utilizes data from the Localiza RENT3 stock within the Bovespa Index.

## Contributions

Contributions are welcome! Feel free to contribute, provide feedback.
