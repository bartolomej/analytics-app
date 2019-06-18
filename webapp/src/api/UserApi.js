import request from './request';


// MULTIPLE RESOURCE REQUESTS

export const getUser = async (userUid, token = 'aaa') => {
  return await request({
    url: `/api/user/${userUid}`,
    method: 'GET',
    token,
  });
};

export const getCoworkers = async (userUid, token = 'aaa') => {
  return await request({
    url: `/api/user/${userUid}/coworkers`,
    method: 'GET',
    token,
  });
};

export const getApps = async (userUid, token = 'aaa') => {
  return await request({
    url: `/api/user/${userUid}/app`,
    method: 'GET',
    token,
  });
};

export const getAppLogs = async (userUid, appName, token = 'aaa') => {
  return await request({
    url: `/api/user/${userUid}/app/${appName}/log`,
    method: 'GET',
    token,
  });
};

export const getAllLogs = async (userUid, token = 'aaa') => {
  return await request({
    url: `/api/user/${userUid}/log`,
    method: 'GET',
    token,
  });
};

export const getAppNodes = async (userUid, appName, token = 'aaa') => {
  return await request({
    url: `/api/user/${userUid}/app/${appName}/node`,
    method: 'GET',
    token,
  });
};


// STATS ENDPOINTS //

export const getLogStats = async (userUid, period, token = 'aaa') => {
  return await request({
    url: `/api/user/${userUid}/log/stats?period=${period}`,
    method: 'GET',
    token,
  });
};