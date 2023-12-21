export const setCookie = (cname: string, cvalue: string) => {
    document.cookie = cname + "=" + cvalue + ";";
}

export const getCookie = (cname: string) => {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for(let i = 0; i <ca.length; i++) {
      let c = ca[i];
        while (c.charAt(0) === ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) === 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

export const checkCookie = (cname: string) => {
    let cookie = getCookie(cname);
    if (cookie !== "") {
        return true;
    }
    return false;
}

export const delCookie = (cname: string) => {
    document.cookie = `${cname}=; expires=Thu, 01 Jan 1970 00:00:00 UTC;`;
}