const GLOBAL_CONFIG = {
  API_HOST: "http://localhost:7000",
  timeout: 4000,
  network_error_message: "Network request timeout"
};

export default async function request(opts = {}) {

  if (!(
    opts.hasOwnProperty('url') &&
    opts.hasOwnProperty('method') &&
    opts.hasOwnProperty('token')
  )) throw new Error("Options missing props");

  let didTimeOut = false;

  let url = GLOBAL_CONFIG.API_HOST + opts.url;
  let method = opts.method.toLowerCase();
  let body = JSON.stringify(opts.data);
  let headers = {
    Accept: 'application/json',
    'Content-Type': 'application/json',
    'Authorization' : `Bearer ${opts.token}`
  };
  let timeout;

  console.group('request');
  console.log('method', method);
  console.log('url', url);
  console.log('body', opts.data);
  console.groupEnd();

  return new Promise(resolve => {
    timeout = setTimeout(() => {
      didTimeOut = true;
      return resolve(
        new Error(
          GLOBAL_CONFIG.network_error_message)
      )
    }, GLOBAL_CONFIG.timeout);
    fetch(url, {
      mode: 'cors',
      method,
      headers,
      body
    }).then(async res => {
      clearTimeout(timeout);
      const response = await res.json();
      console.log('response', response);
      return resolve(response.data);
    }).catch(error => {
      error = new Error(error.message);
      console.log('req error', error);
      return resolve(error);
    })
  })

}