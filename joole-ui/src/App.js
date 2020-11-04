import Home from './containers/Home/Home';

import React, { Component } from 'react'
import { Redirect, Switch, withRouter, Route } from 'react-router-dom';
import { connect } from 'react-redux';
import * as actions from './store/actions/index';
import ProductList from './containers/ProductList/ProductList';
import Product from './containers/Product/Product';
import Logout from './components/Auth/Logout';
import Compare from './containers/Compare/Compare';

class App extends Component {
  componentDidMount() {
    console.log(this.props)
    this.props.onTryAutoSignup();
  }

  render() {
    let routes = (
      <Switch>
        <Route path="/" component={Home}/>
        <Redirect to="/"/>
      </Switch>
    );

    if(this.props.isAuthenticated) {
      routes = (
        <Switch>
          <Route path="/" exact component={Home}/>
          <Route path="/products" exact component={ProductList}/>
          <Route path="/products/:id" exact component={Product}/>
          <Route path="/compare" exact component={Compare}/>
          <Route path="/logout" exact component={Logout}/>
          <Redirect to="/"/>
        </Switch>
      )
    }
    return (
      <div>
        {routes}
      </div>
    )
  }
}

const mapStateToProps = state => {
  return {
    isAuthenticated: state.auth.token !== null
  };
};

const mapDispatchToProps = dispatch => {
  return {
    onTryAutoSignup: () => dispatch(actions.authCheckState())
  }
}

export default withRouter(connect(mapStateToProps, mapDispatchToProps)(App));
