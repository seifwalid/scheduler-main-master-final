import axios from "axios";

export const baseUrl = "http://localhost:8080/api/";

export function apiDir(endpoint: string) {
  return baseUrl + endpoint;
}

export async function get(endpoint: string) {
  return axios.get(apiDir(endpoint)).catch(err => {
    console.log("there's an error: ", err);
  });
}

export async function post(endpoint: string, body: any) {
  return axios.post(apiDir(endpoint), body).catch(err => {
    console.log("there's an error: ", err);
  });
}

export async function put(endpoint: string, body: any) {
  return axios.put(apiDir(endpoint), body).catch(err => {
    console.log("there's an error: ", err);
  });
}

export async function del(endpoint: string) {
  return axios.delete(apiDir(endpoint)).catch(err => {
    console.log("there's an error: ", err);
  });
}