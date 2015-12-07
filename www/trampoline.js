var trampoline = {
    done: function (result) {
        return {isDone: true, result: result};
    },
    cont: function (thunk) {
        return {isDone: false, thunk: thunk};
    },
    tramp: function (bounce) {
        while (!bounce.isDone) {
            bounce = bounce.thunk();
        }
        return bounce.result;
    }
};

function trampSumOf (n) {
    var _sumof = function me (acc, n) {
        return n > 0
        ? trampoline.cont(function () { 
            return me(acc + n, n - 1); 
            })
        : trampoline.done (acc);
    };
    
    return trampoline.tramp(_sumof(0, n));
}


function recursiveSumOf (n) {
    return n > 0
        ? n + recursiveSumOf (n - 1)
        : 0 
}

var tops = 10000;
console.log(trampSumOf(tops));
console.log(recursiveSumOf(tops));
