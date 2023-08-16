export function dateToString(date: Date) {
  const res = `${date.getFullYear()}-${date.getMonth()}-${date.getDay()}T${date.getHours()}:${date.getMinutes()}`;
  console.log(res);
  return res;
}

export function arrayToDate(array: number[]) {

}

function makeTwoDigits(n: number) {
  let res = String(n);
  while (res.length < 2) {
    res = '0' + res;
  }
  return res;
}

function makeFourDigits(n: number) {
  let res = String(n);
  while (res.length < 4) {
    res = '0' + res;
  }
  return res;
}

export function arrayDateToString(arrayDate: number[]) {
  const res = `${makeFourDigits(arrayDate[0])}-${makeTwoDigits(arrayDate[1])}-${makeTwoDigits(arrayDate[2])}T${makeTwoDigits(arrayDate[3])}:${makeTwoDigits(arrayDate[4])}`;
  console.log(res);
  return res;
}